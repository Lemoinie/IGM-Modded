package com.lemoinie.idleguildcompanion;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SaveManager {

    public enum EngineType {
        DIRECT_PROVIDER("Direct Live Sync"),
        ROOT("Root (Direct)"),
        SHIZUKU("Shizuku (ADB)"),
        DIRECT_FILE("Direct Sandbox"),
        DOWNLOAD_FOLDER("Downloads Sync");

        public final String label;
        EngineType(String label) { this.label = label; }
    }

    private static final String PKG_MODDED = "it.paranoidsquirrels.idleguildmastermod";
    private static final String PKG_VANILLA = "it.paranoidsquirrels.idleguildmaster";
    private static final String PROVIDER_URI_MODDED = "content://it.paranoidsquirrels.idleguildmastermod.saveprovider";
    private static final String PROVIDER_URI_VANILLA = "content://it.paranoidsquirrels.idleguildmaster.saveprovider";
    private static final String PKG_DATA_PATH_MODDED = "/data/data/it.paranoidsquirrels.idleguildmastermod/files/data.txt";
    private static final String PKG_DATA_PATH_VANILLA = "/data/data/it.paranoidsquirrels.idleguildmaster/files/data.txt";
    private static final String APP_DIR_NAME = "IdleGuildCompanion";
    private static final String BACKUP_DIR_NAME = "backups";
    private static final String EXPORT_DIR_NAME = "exports";

    private final Context context;
    private EngineType activeEngine = EngineType.DOWNLOAD_FOLDER;
    private boolean targetModded = true;
    private File lastSafetySnapshot = null;

    public boolean isTargetModded() { return targetModded; }

    /** Returns the provider URI for the currently-targeted package (modded preferred). */
    private String providerUri() { return targetModded ? PROVIDER_URI_MODDED : PROVIDER_URI_VANILLA; }

    /** Returns the save file path for the currently-targeted package. */
    private String pkgDataPath() { return targetModded ? PKG_DATA_PATH_MODDED : PKG_DATA_PATH_VANILLA; }


    public SaveManager(Context context) {
        this.context = context;
        ensureDirectories();
        detectEngine();
    }

    public EngineType getActiveEngine() {
        return activeEngine;
    }

    public File getLastSafetySnapshot() {
        return lastSafetySnapshot;
    }

    public void ensureDirectories() {
        File baseDir = getCompanionDir();
        new File(baseDir, BACKUP_DIR_NAME).mkdirs();
        new File(baseDir, EXPORT_DIR_NAME).mkdirs();
    }

    public File getCompanionDir() {
        File external = Environment.getExternalStorageDirectory();
        File dir = new File(external, APP_DIR_NAME);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public File getBackupsDir() {
        File dir = new File(getCompanionDir(), BACKUP_DIR_NAME);
        if (!dir.exists()) dir.mkdirs();
        return dir;
    }

    public void detectEngine() {
        // 0. Prefer the modded game package (IGMod) since that's the one we build
        //    and install. Fall back to vanilla only when the modded path/provider
        //    is not reachable.
        targetModded = true;

        // 1. Test Direct ContentProvider IPC (Seamless instant sync with modded game)
        try {
            Bundle res = context.getContentResolver().call(Uri.parse(PROVIDER_URI_MODDED), "READ_SAVE", null, null);
            if (res != null && res.getBoolean("success", false)) {
                activeEngine = EngineType.DIRECT_PROVIDER;
                return;
            }
        } catch (Exception ignored) {}

        // 1b. Test vanilla ContentProvider
        try {
            Bundle res = context.getContentResolver().call(Uri.parse(PROVIDER_URI_VANILLA), "READ_SAVE", null, null);
            if (res != null && res.getBoolean("success", false)) {
                targetModded = false;
                activeEngine = EngineType.DIRECT_PROVIDER;
                return;
            }
        } catch (Exception ignored) {}

        // 2. Test Direct File (if sandbox access allows) - modded package first
        if (new File(PKG_DATA_PATH_MODDED).canRead()) {
            targetModded = true;
            activeEngine = EngineType.DIRECT_FILE;
            return;
        }
        if (new File(PKG_DATA_PATH_VANILLA).canRead()) {
            targetModded = false;
            activeEngine = EngineType.DIRECT_FILE;
            return;
        }

        // 3. Test Root
        if (testCommand("su -c id")) {
            activeEngine = EngineType.ROOT;
            return;
        }

        // 4. Test Shizuku / local adb wrapper
        if (testCommand("shizuku-exec id") || testCommand("rish -c id")) {
            activeEngine = EngineType.SHIZUKU;
            return;
        }

        // 5. Default: Download sync folder / SAF
        activeEngine = EngineType.DOWNLOAD_FOLDER;
    }

    private boolean testCommand(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(cmd.split(" "));
            return p.waitFor() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    /** Returns the backup file path for the currently-targeted package. */
    private String pkgDataBackupPath() {
        return (targetModded
            ? "/data/data/it.paranoidsquirrels.idleguildmastermod/files/databackup.txt"
            : "/data/data/it.paranoidsquirrels.idleguildmaster/files/databackup.txt");
    }

    public String readGameSave() {
        switch (activeEngine) {
            case DIRECT_PROVIDER:
                try {
                    Bundle res = context.getContentResolver().call(Uri.parse(providerUri()), "READ_SAVE", null, null);
                    if (res != null && res.getBoolean("success", false)) {
                        return res.getString("save_content", "");
                    }
                } catch (Exception ignored) {}
                break;
            case ROOT:
                return execRead("su -c cat " + pkgDataPath());
            case SHIZUKU:
                if (testCommand("rish -c id")) {
                    return execRead("rish -c cat " + pkgDataPath());
                }
                return execRead("shizuku-exec cat " + pkgDataPath());
            case DIRECT_FILE:
                return readFileDirect(new File(pkgDataPath()));
            case DOWNLOAD_FOLDER:
            default:
                break;
        }

        // Fallback: Check Downloads folder
        File downloadSave = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "IdleGuildMaster_save.json");
        if (downloadSave.exists()) {
            return readFileDirect(downloadSave);
        }
        return "";
    }

    public boolean writeGameSave(String rawSave) {
        if (rawSave == null || rawSave.isEmpty()) return false;

        // Stamp current time on lastAccess so Utils.getNewestSaveFile always considers this save the newest!
        try {
            if (rawSave.trim().startsWith("{")) {
                org.json.JSONObject obj = new org.json.JSONObject(rawSave);
                obj.put("lastAccess", System.currentTimeMillis());
                rawSave = obj.toString();
            }
        } catch (Exception ignored) {}

        switch (activeEngine) {
            case DIRECT_PROVIDER:
                try {
                    Bundle args = new Bundle();
                    args.putString("save_content", rawSave);
                    Bundle res = context.getContentResolver().call(Uri.parse(providerUri()), "WRITE_SAVE", null, args);
                    if (res != null && res.getBoolean("success", false)) {
                        return true;
                    }
                } catch (Exception ignored) {}
                break;
            case ROOT: {
                File tmp = new File(context.getCacheDir(), "tmp_save.txt");
                writeFileDirect(tmp, rawSave);
                String cmd = String.format("su -c cp %s %s && su -c cp %s %s && su -c chmod 660 %s", tmp.getAbsolutePath(), pkgDataPath(), tmp.getAbsolutePath(), pkgDataBackupPath(), pkgDataPath());
                return execWrite(cmd);
            }
            case SHIZUKU: {
                File tmp = new File(context.getCacheDir(), "tmp_save.txt");
                writeFileDirect(tmp, rawSave);
                String cmd = String.format("rish -c cp %s %s && rish -c cp %s %s", tmp.getAbsolutePath(), pkgDataPath(), tmp.getAbsolutePath(), pkgDataBackupPath());
                return execWrite(cmd);
            }
            case DIRECT_FILE:
                File backupFile = new File(pkgDataBackupPath());
                writeFileDirect(backupFile, rawSave);
                return writeFileDirect(new File(pkgDataPath()), rawSave);
            case DOWNLOAD_FOLDER:
            default:
                break;
        }

        File downloadSave = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "IdleGuildMaster_save.json");
        return writeFileDirect(downloadSave, rawSave);
    }

    public SaveMetadata createBackup(String optionalTag, boolean isSafety) {
        String raw = readGameSave();
        if (raw == null || raw.trim().isEmpty()) {
            return null;
        }

        SaveMetadata meta = new SaveMetadata();
        meta.isSafetySnapshot = isSafety;
        SaveParser.populateMetadata(meta, raw);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
        String timestamp = sdf.format(new Date());

        String filename;
        if (isSafety) {
            filename = "pre_restore_safety_" + timestamp + ".json";
        } else if (optionalTag != null && !optionalTag.trim().isEmpty()) {
            filename = timestamp + "_" + optionalTag.trim().replaceAll("[^a-zA-Z0-9_-]", "_") + ".json";
        } else {
            filename = timestamp + ".json";
        }

        File backupFile = new File(getBackupsDir(), filename);
        writeFileDirect(backupFile, meta.toJsonObject().toString());

        if (isSafety) {
            this.lastSafetySnapshot = backupFile;
        }

        return meta;
    }

    public boolean restoreBackup(File backupFile) {
        if (backupFile == null || !backupFile.exists()) return false;

        String fileContent = readFileDirect(backupFile);
        if (fileContent.isEmpty()) return false;

        // 🛡️ STEP 1: Pre-Restore Safety Snapshot
        createBackup("safety_backup", true);

        // STEP 2: Extract raw save string
        String rawToRestore = SaveParser.extractRawGameSave(fileContent);

        // STEP 3: Write to game
        return writeGameSave(rawToRestore);
    }

    public boolean undoLastRestore() {
        if (lastSafetySnapshot != null && lastSafetySnapshot.exists()) {
            String content = readFileDirect(lastSafetySnapshot);
            String raw = SaveParser.extractRawGameSave(content);
            boolean ok = writeGameSave(raw);
            if (ok) {
                lastSafetySnapshot = null;
            }
            return ok;
        }
        return false;
    }

    public List<File> listBackupFiles() {
        File dir = getBackupsDir();
        File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
        List<File> list = new ArrayList<>();
        if (files != null) {
            Collections.addAll(list, files);
            list.sort((f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));
        }
        return list;
    }

    private String execRead(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"sh", "-c", cmd});
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            p.waitFor();
            return sb.toString().trim();
        } catch (Exception e) {
            return "";
        }
    }

    private boolean execWrite(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"sh", "-c", cmd});
            return p.waitFor() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static String readFileDirect(File file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean writeFileDirect(File file, String content) {
        try {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(content.getBytes());
                fos.flush();
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
