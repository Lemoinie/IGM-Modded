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
        ROOT("Root Access"),
        SHIZUKU("Shizuku ADB"),
        DIRECT_FILE("Direct Sandbox"),
        DOWNLOAD_FOLDER("Downloads Folder");

        public final String label;
        EngineType(String label) { this.label = label; }
    }

    public static final String PKG_MODDED_REBUILT = "it.paranoidsquirrels.idleguildmaster.rebuilt";
    public static final String PKG_MODDED_LEGACY = "it.paranoidsquirrels.idleguildmastermod";
    public static final String PKG_VANILLA = "it.paranoidsquirrels.idleguildmaster";

    private static final String APP_DIR_NAME = "IdleGuildCompanion";
    private static final String BACKUP_DIR_NAME = "backups";
    private static final String EXPORT_DIR_NAME = "exports";
    public static final String SAFETY_BACKUP_NAME = "pre_restore_safety.json";

    private final Context context;
    private EngineType activeEngine = EngineType.DOWNLOAD_FOLDER;
    private String activePackage = PKG_MODDED_REBUILT;
    private File lastSafetySnapshot = null;

    public SaveManager(Context context) {
        this.context = context;
        ensureDirectories();
        detectEngine();
    }

    public String getActivePackageName() {
        return activePackage;
    }

    public String getActiveProviderUri() {
        return "content://" + activePackage + ".saveprovider";
    }

    public String getActiveDataPath() {
        return "/data/data/" + activePackage + "/files/data.txt";
    }

    public String getActiveDataBackupPath() {
        return "/data/data/" + activePackage + "/files/databackup.txt";
    }

    public EngineType getActiveEngine() {
        return activeEngine;
    }

    public boolean isPackageInstalled(String pkgName) {
        try {
            context.getPackageManager().getPackageInfo(pkgName, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
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
        // Auto-detect installed game package: prefer .rebuilt, then legacy mod, then vanilla
        if (isPackageInstalled(PKG_MODDED_REBUILT)) {
            activePackage = PKG_MODDED_REBUILT;
        } else if (isPackageInstalled(PKG_MODDED_LEGACY)) {
            activePackage = PKG_MODDED_LEGACY;
        } else if (isPackageInstalled(PKG_VANILLA)) {
            activePackage = PKG_VANILLA;
        } else {
            activePackage = PKG_MODDED_REBUILT;
        }

        String providerUri = getActiveProviderUri();
        String dataPath = getActiveDataPath();

        // 1. Direct ContentProvider IPC (Instant live memory + disk sync)
        try {
            Bundle res = context.getContentResolver().call(Uri.parse(providerUri), "READ_SAVE", null, null);
            if (res != null && res.getBoolean("success", false)) {
                activeEngine = EngineType.DIRECT_PROVIDER;
                return;
            }
        } catch (Exception ignored) {}

        // 2. Direct File sandbox read
        if (new File(dataPath).canRead()) {
            activeEngine = EngineType.DIRECT_FILE;
            return;
        }

        // 3. Root access
        if (testCommand("su -c id")) {
            activeEngine = EngineType.ROOT;
            return;
        }

        // 4. Shizuku ADB
        if (testCommand("rish -c id") || testCommand("shizuku-exec id")) {
            activeEngine = EngineType.SHIZUKU;
            return;
        }

        // 5. Fallback: Downloads sync folder
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

    public String readGameSave() {
        switch (activeEngine) {
            case DIRECT_PROVIDER:
                try {
                    Bundle res = context.getContentResolver().call(Uri.parse(getActiveProviderUri()), "READ_SAVE", null, null);
                    if (res != null && res.getBoolean("success", false)) {
                        return res.getString("save_content", "");
                    }
                } catch (Exception ignored) {}
                break;
            case ROOT:
                return execRead("su -c cat " + getActiveDataPath());
            case SHIZUKU:
                if (testCommand("rish -c id")) {
                    return execRead("rish -c cat " + getActiveDataPath());
                }
                return execRead("shizuku-exec cat " + getActiveDataPath());
            case DIRECT_FILE:
                return readFileDirect(new File(getActiveDataPath()));
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

        // Stamp current time on lastAccess so the game's file loader always considers this save the newest!
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
                    Bundle res = context.getContentResolver().call(Uri.parse(getActiveProviderUri()), "WRITE_SAVE", null, args);
                    if (res != null && res.getBoolean("success", false)) {
                        return true;
                    }
                } catch (Exception ignored) {}
                break;
            case ROOT: {
                File tmp = new File(context.getCacheDir(), "tmp_save.txt");
                writeFileDirect(tmp, rawSave);
                String cmd = String.format("su -c cp %s %s && su -c cp %s %s && su -c chmod 660 %s",
                        tmp.getAbsolutePath(), getActiveDataPath(),
                        tmp.getAbsolutePath(), getActiveDataBackupPath(),
                        getActiveDataPath());
                return execWrite(cmd);
            }
            case SHIZUKU: {
                File tmp = new File(context.getCacheDir(), "tmp_save.txt");
                writeFileDirect(tmp, rawSave);
                String cmd = String.format("rish -c cp %s %s && rish -c cp %s %s",
                        tmp.getAbsolutePath(), getActiveDataPath(),
                        tmp.getAbsolutePath(), getActiveDataBackupPath());
                return execWrite(cmd);
            }
            case DIRECT_FILE:
                File backupFile = new File(getActiveDataBackupPath());
                writeFileDirect(backupFile, rawSave);
                return writeFileDirect(new File(getActiveDataPath()), rawSave);
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
        meta.targetPackage = getActivePackageName();
        SaveParser.populateMetadata(meta, raw);

        if (optionalTag != null && !optionalTag.trim().isEmpty()) {
            meta.customTag = optionalTag.trim();
        }

        File backupFile;
        if (isSafety) {
            // Strictly only ONE safety snapshot: clean up any legacy pre_restore_safety files
            cleanOldSafetySnapshots(0);
            backupFile = new File(getBackupsDir(), SAFETY_BACKUP_NAME);
            meta.customTag = "Safety Snapshot (Pre-Restore)";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
            String timestamp = sdf.format(new Date());
            String filename;
            if (optionalTag != null && !optionalTag.trim().isEmpty()) {
                filename = timestamp + "_" + optionalTag.trim().replaceAll("[^a-zA-Z0-9_-]", "_") + ".json";
            } else {
                filename = timestamp + ".json";
            }
            backupFile = new File(getBackupsDir(), filename);
        }

        writeFileDirect(backupFile, meta.toJsonObject().toString());

        if (isSafety) {
            this.lastSafetySnapshot = backupFile;
        }

        return meta;
    }

    public boolean renameBackup(File file, String newTag) {
        if (file == null || !file.exists()) return false;
        try {
            String content = readFileDirect(file);
            SaveMetadata meta = SaveMetadata.fromJsonString(content);
            meta.customTag = newTag != null ? newTag.trim() : "";
            return writeFileDirect(file, meta.toJsonObject().toString());
        } catch (Exception e) {
            return false;
        }
    }

    public File togglePin(File file) {
        if (file == null || !file.exists()) return file;
        try {
            String content = readFileDirect(file);
            SaveMetadata meta = SaveMetadata.fromJsonString(content);
            meta.isPinned = !meta.isPinned;

            String oldName = file.getName();
            File newFile = file;
            if (meta.isPinned && !oldName.startsWith("pin_")) {
                newFile = new File(file.getParentFile(), "pin_" + oldName);
                if (file.renameTo(newFile)) {
                    file = newFile;
                }
            } else if (!meta.isPinned && oldName.startsWith("pin_")) {
                newFile = new File(file.getParentFile(), oldName.substring(4));
                if (file.renameTo(newFile)) {
                    file = newFile;
                }
            }

            writeFileDirect(file, meta.toJsonObject().toString());
            return file;
        } catch (Exception e) {
            return file;
        }
    }

    public int cleanOldSafetySnapshots(int keepCount) {
        File dir = getBackupsDir();
        File[] files = dir.listFiles((d, name) -> name.startsWith("pre_restore_safety") || name.startsWith("pre_"));
        if (files == null) {
            return 0;
        }

        List<File> list = new ArrayList<>();
        Collections.addAll(list, files);
        list.sort((f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));

        int deleted = 0;
        for (int i = keepCount; i < list.size(); i++) {
            if (list.get(i).delete()) {
                deleted++;
            }
        }
        return deleted;
    }

    public File getLastSafetySnapshot() {
        if (lastSafetySnapshot != null && lastSafetySnapshot.exists()) {
            return lastSafetySnapshot;
        }

        // Look on disk for the fixed single safety snapshot or newest pre_ file
        File singleSafety = new File(getBackupsDir(), SAFETY_BACKUP_NAME);
        if (singleSafety.exists()) {
            lastSafetySnapshot = singleSafety;
            return lastSafetySnapshot;
        }

        File dir = getBackupsDir();
        File[] files = dir.listFiles((d, name) -> name.startsWith("pre_restore_safety") || name.startsWith("pre_"));
        if (files != null && files.length > 0) {
            List<File> list = new ArrayList<>();
            Collections.addAll(list, files);
            list.sort((f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));
            lastSafetySnapshot = list.get(0);
            return lastSafetySnapshot;
        }
        return null;
    }

    public boolean restoreBackup(File backupFile) {
        if (backupFile == null || !backupFile.exists()) return false;

        String fileContent = readFileDirect(backupFile);
        if (fileContent.isEmpty()) return false;

        // Auto create strictly ONE safety snapshot before overwriting
        createBackup("safety_backup", true);

        // Extract raw save
        String rawToRestore = SaveParser.extractRawGameSave(fileContent);

        // Cache for file provider fallback
        File cacheFile = new File(context.getCacheDir(), "shared_save.txt");
        writeFileDirect(cacheFile, rawToRestore);

        // Write directly to game
        return writeGameSave(rawToRestore);
    }

    public boolean undoLastRestore() {
        File safety = getLastSafetySnapshot();
        if (safety != null && safety.exists()) {
            String content = readFileDirect(safety);
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
            // Sort: Pinned first, then by lastModified descending
            list.sort((f1, f2) -> {
                boolean p1 = f1.getName().startsWith("pin_");
                boolean p2 = f2.getName().startsWith("pin_");
                if (p1 && !p2) return -1;
                if (!p1 && p2) return 1;
                return Long.compare(f2.lastModified(), f1.lastModified());
            });
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
