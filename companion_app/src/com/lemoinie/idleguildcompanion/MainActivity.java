package com.lemoinie.idleguildcompanion;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity {

    private static final int REQ_STORAGE_PERMISSION = 1001;
    private static final int REQ_CREATE_DRIVE_DOC = 2001;
    private static final int REQ_OPEN_DRIVE_DOC = 2002;

    private SaveManager saveManager;

    private TextView tvEngineBadge;
    private TextView tvCurrentStatus;
    private LinearLayout layoutCurrentMetrics;
    private TextView tvLiveHeroes;
    private TextView tvLiveGold;
    private TextView tvLiveGems;
    private LinearLayout layoutUndoBanner;
    private Button btnUndoRestore;
    private LinearLayout layoutBackupsList;
    private TextView tvNoBackups;
    private TextView tvBackupCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveManager = new SaveManager(this);

        initViews();
        checkPermissions();
        handleIncomingIntent(getIntent());
        refreshAll();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIncomingIntent(intent);
        refreshAll();
    }

    private void handleIncomingIntent(Intent intent) {
        if (intent == null) return;
        String action = intent.getAction();
        if (Intent.ACTION_SEND.equals(action)) {
            Uri streamUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
            if (streamUri != null) {
                try (InputStream is = getContentResolver().openInputStream(streamUri)) {
                    byte[] buf = new byte[is.available()];
                    is.read(buf);
                    String rawSave = new String(buf);
                    if (!rawSave.trim().isEmpty()) {
                        SaveMetadata meta = new SaveMetadata();
                        meta.isSafetySnapshot = false;
                        SaveParser.populateMetadata(meta, rawSave);

                        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
                        File backupFile = new File(saveManager.getBackupsDir(), sdf.format(new java.util.Date()) + "_Vanilla_DEBUG000.json");
                        SaveManager.writeFileDirect(backupFile, meta.toJsonObject().toString());

                        // Automatically sync to modded game if direct provider is available
                        saveManager.writeGameSave(rawSave);

                        Toast.makeText(this, "🎉 Vanilla Save imported from DEBUG000 & Synced!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(this, "Failed to read shared save: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void initViews() {
        tvEngineBadge = findViewById(R.id.tv_engine_badge);
        tvCurrentStatus = findViewById(R.id.tv_current_status);
        layoutCurrentMetrics = findViewById(R.id.layout_current_metrics);
        tvLiveHeroes = findViewById(R.id.tv_live_heroes);
        tvLiveGold = findViewById(R.id.tv_live_gold);
        tvLiveGems = findViewById(R.id.tv_live_gems);
        layoutUndoBanner = findViewById(R.id.layout_undo_banner);
        btnUndoRestore = findViewById(R.id.btn_undo_restore);
        layoutBackupsList = findViewById(R.id.layout_backups_list);
        tvNoBackups = findViewById(R.id.tv_no_backups);
        tvBackupCount = findViewById(R.id.tv_backup_count);

        findViewById(R.id.btn_backup_now).setOnClickListener(v -> handleBackupNow());
        findViewById(R.id.btn_refresh_status).setOnClickListener(v -> refreshAll());
        findViewById(R.id.btn_drive_save).setOnClickListener(v -> handleDriveSave());
        findViewById(R.id.btn_drive_load).setOnClickListener(v -> handleDriveLoad());
        findViewById(R.id.btn_code_import).setOnClickListener(v -> handleCodeImport());

        btnUndoRestore.setOnClickListener(v -> handleUndoRestore());
    }

    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                try {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    startActivityForResult(intent, REQ_STORAGE_PERMISSION);
                } catch (Exception e) {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                    startActivityForResult(intent, REQ_STORAGE_PERMISSION);
                }
            }
        }
    }

    private void refreshAll() {
        saveManager.detectEngine();
        tvEngineBadge.setText(saveManager.getActiveEngine().label);

        // Update live save status
        String liveRaw = saveManager.readGameSave();
        if (liveRaw != null && !liveRaw.trim().isEmpty()) {
            SaveMetadata meta = new SaveMetadata();
            SaveParser.populateMetadata(meta, liveRaw);

            tvCurrentStatus.setText("Save Found & Synced");
            layoutCurrentMetrics.setVisibility(View.VISIBLE);

            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            tvLiveHeroes.setText("⚔️ " + meta.heroCount + " Heroes");
            tvLiveGold.setText("💰 " + nf.format(meta.gold) + " Gold");
            tvLiveGems.setText("💎 " + nf.format(meta.gems) + " Gems");
        } else {
            tvCurrentStatus.setText("No game save detected yet.\nEnsure Idle Guild Master is installed.");
            layoutCurrentMetrics.setVisibility(View.GONE);
        }

        // Check undo state
        File safety = saveManager.getLastSafetySnapshot();
        if (safety != null && safety.exists()) {
            layoutUndoBanner.setVisibility(View.VISIBLE);
        } else {
            layoutUndoBanner.setVisibility(View.GONE);
        }

        // Render backups list
        renderBackupsList();
    }

    private void renderBackupsList() {
        layoutBackupsList.removeAllViews();
        List<File> files = saveManager.listBackupFiles();

        if (files.isEmpty()) {
            tvNoBackups.setVisibility(View.VISIBLE);
            layoutBackupsList.addView(tvNoBackups);
            tvBackupCount.setText("BACKUP SNAPSHOTS (0)");
            return;
        }

        tvNoBackups.setVisibility(View.GONE);
        tvBackupCount.setText("BACKUP SNAPSHOTS (" + files.size() + ")");

        LayoutInflater inflater = LayoutInflater.from(this);
        NumberFormat nf = NumberFormat.getInstance(Locale.US);

        for (File file : files) {
            View itemView = inflater.inflate(R.layout.item_backup, layoutBackupsList, false);

            TextView tvTitle = itemView.findViewById(R.id.tv_backup_title);
            TextView tvType = itemView.findViewById(R.id.tv_backup_type);
            TextView tvHeroes = itemView.findViewById(R.id.tv_backup_heroes);
            TextView tvGold = itemView.findViewById(R.id.tv_backup_gold);
            TextView tvGems = itemView.findViewById(R.id.tv_backup_gems);
            Button btnDelete = itemView.findViewById(R.id.btn_backup_delete);
            Button btnExport = itemView.findViewById(R.id.btn_backup_export);
            Button btnRestore = itemView.findViewById(R.id.btn_backup_restore);

            String content = SaveManager.readFileDirect(file);
            SaveMetadata meta = SaveMetadata.fromJsonString(content);

            tvTitle.setText(file.getName().replace(".json", ""));
            if (meta.isSafetySnapshot || file.getName().startsWith("pre_restore_safety")) {
                tvType.setText("Safety Snapshot");
                tvType.setTextColor(getResources().getColor(R.color.gold));
            } else {
                tvType.setText("Manual Backup");
                tvType.setTextColor(getResources().getColor(R.color.accent_blue));
            }

            tvHeroes.setText("⚔️ " + meta.heroCount + " Heroes");
            tvGold.setText("💰 " + nf.format(meta.gold));
            tvGems.setText("💎 " + nf.format(meta.gems));

            btnRestore.setOnClickListener(v -> confirmRestore(file, meta));
            btnExport.setOnClickListener(v -> copyBackupCode(content));
            btnDelete.setOnClickListener(v -> confirmDelete(file));

            layoutBackupsList.addView(itemView);
        }
    }

    private void handleBackupNow() {
        SaveMetadata meta = saveManager.createBackup(null, false);
        if (meta != null) {
            Toast.makeText(this, "💾 Backup created successfully!", Toast.LENGTH_SHORT).show();
            refreshAll();
        } else {
            Toast.makeText(this, "❌ Failed to read save file!", Toast.LENGTH_SHORT).show();
        }
    }

    private void confirmRestore(File file, SaveMetadata meta) {
        new AlertDialog.Builder(this)
            .setTitle("🛡️ Restore Backup")
            .setMessage("Are you sure you want to restore this save?\n\n"
                + "• Heroes: " + meta.heroCount + "\n"
                + "• Gold: " + NumberFormat.getInstance(Locale.US).format(meta.gold) + "\n"
                + "• Gems: " + NumberFormat.getInstance(Locale.US).format(meta.gems) + "\n\n"
                + "A Safety Snapshot will be created automatically before overwriting.")
            .setPositiveButton("Restore", (d, w) -> {
                saveManager.createBackup("pre_restore", true);

                String fileContent = SaveManager.readFileDirect(file);
                String rawToRestore = SaveParser.extractRawGameSave(fileContent);

                // Write to cache for FileProvider share
                File cacheFile = new File(getCacheDir(), "shared_save.txt");
                SaveManager.writeFileDirect(cacheFile, rawToRestore);

                // Also write via IPC
                saveManager.writeGameSave(rawToRestore);

                refreshAll();

                // Open System Share Sheet / Chooser like DEBUG000
                shareSaveToGame(rawToRestore);
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void handleUndoRestore() {
        new AlertDialog.Builder(this)
            .setTitle("↩️ Undo Last Restore")
            .setMessage("Revert game save back to the state before your last restore?")
            .setPositiveButton("Undo Now", (d, w) -> {
                File lastSafety = saveManager.getLastSafetySnapshot();
                if (lastSafety != null && lastSafety.exists()) {
                    String content = SaveManager.readFileDirect(lastSafety);
                    String raw = SaveParser.extractRawGameSave(content);

                    File cacheFile = new File(getCacheDir(), "shared_save.txt");
                    SaveManager.writeFileDirect(cacheFile, raw);

                    saveManager.writeGameSave(raw);
                    refreshAll();

                    shareSaveToGame(raw);
                } else {
                    Toast.makeText(this, "❌ No safety snapshot found!", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void shareSaveToGame(String rawSave) {
        try {
            Uri uri = Uri.parse("content://com.lemoinie.idleguildcompanion.fileprovider/shared_save.txt");
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.putExtra(Intent.EXTRA_TEXT, rawSave);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            Intent chooser = Intent.createChooser(shareIntent, "Select 'IGMod' (Idle Guild Master mod) to load save:");
            startActivity(chooser);
        } catch (Exception e) {
            Toast.makeText(this, "Opening game...", Toast.LENGTH_SHORT).show();
            openGame();
        }
    }

    private void openGame() {
        try {
            // Prefer the modded game (IGMod); fall back to the vanilla store app.
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("it.paranoidsquirrels.idleguildmastermod");
            if (launchIntent == null) {
                launchIntent = getPackageManager().getLaunchIntentForPackage("it.paranoidsquirrels.idleguildmaster");
            }
            if (launchIntent != null) {
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(launchIntent);
            }
        } catch (Exception ignored) {}
    }

    private void copyBackupCode(String content) {
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("IdleGuildMaster_Save", content);
        cm.setPrimaryClip(clip);
        Toast.makeText(this, "📋 Save code copied to clipboard!", Toast.LENGTH_SHORT).show();
    }

    private void confirmDelete(File file) {
        new AlertDialog.Builder(this)
            .setTitle("Delete Backup")
            .setMessage("Delete " + file.getName() + "?")
            .setPositiveButton("Delete", (d, w) -> {
                file.delete();
                refreshAll();
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void handleCodeImport() {
        EditText input = new EditText(this);
        input.setHint("Paste save JSON or metadata here...");

        new AlertDialog.Builder(this)
            .setTitle("📋 Import Save Code")
            .setView(input)
            .setPositiveButton("Import", (d, w) -> {
                String text = input.getText().toString().trim();
                if (!text.isEmpty()) {
                    String raw = SaveParser.extractRawGameSave(text);
                    saveManager.createBackup("pre_import_safety", true);
                    boolean ok = saveManager.writeGameSave(raw);
                    if (ok) {
                        Toast.makeText(this, "✅ Imported successfully!", Toast.LENGTH_SHORT).show();
                        refreshAll();
                    } else {
                        Toast.makeText(this, "❌ Failed to write save!", Toast.LENGTH_SHORT).show();
                    }
                }
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void handleDriveSave() {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/json");
        intent.putExtra(Intent.EXTRA_TITLE, "IdleGuildMaster_Backup.json");
        startActivityForResult(intent, REQ_CREATE_DRIVE_DOC);
    }

    private void handleDriveLoad() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        startActivityForResult(intent, REQ_OPEN_DRIVE_DOC);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();

            if (requestCode == REQ_CREATE_DRIVE_DOC) {
                try (OutputStream os = getContentResolver().openOutputStream(uri)) {
                    String liveSave = saveManager.readGameSave();
                    SaveMetadata meta = new SaveMetadata();
                    SaveParser.populateMetadata(meta, liveSave);
                    os.write(meta.toJsonObject().toString().getBytes());
                    os.flush();
                    Toast.makeText(this, "☁️ Saved to Google Drive / Document Provider!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(this, "❌ Failed to write to Drive: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == REQ_OPEN_DRIVE_DOC) {
                try (InputStream is = getContentResolver().openInputStream(uri)) {
                    byte[] buf = new byte[is.available()];
                    is.read(buf);
                    String fileContent = new String(buf);

                    String raw = SaveParser.extractRawGameSave(fileContent);
                    saveManager.createBackup("pre_drive_load_safety", true);
                    boolean ok = saveManager.writeGameSave(raw);
                    if (ok) {
                        Toast.makeText(this, "☁️ Loaded from Drive successfully!", Toast.LENGTH_LONG).show();
                        refreshAll();
                    } else {
                        Toast.makeText(this, "❌ Failed to apply save from Drive!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(this, "❌ Failed to read from Drive: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
