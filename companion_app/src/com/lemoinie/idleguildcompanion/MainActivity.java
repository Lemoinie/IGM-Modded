package com.lemoinie.idleguildcompanion;

import android.app.Activity;
import android.app.AlertDialog;
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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity {

    private static final int REQ_STORAGE_PERMISSION = 1001;

    private enum FilterMode {
        ALL,
        PINNED,
        MANUAL,
        SAFETY
    }

    private SaveManager saveManager;
    private FilterMode currentFilter = FilterMode.ALL;

    private TextView tvEngineBadge;
    private TextView tvCurrentStatus;
    private LinearLayout layoutCurrentMetrics;
    private TextView tvLiveHeroes;
    private TextView tvLiveGold;
    private TextView tvLiveGoldSub;
    private TextView tvLiveGems;
    private TextView tvLiveGemsSub;

    private LinearLayout layoutUndoBanner;
    private Button btnUndoRestore;

    private TextView tvBackupCount;
    private TextView chipFilterAll;
    private TextView chipFilterPinned;
    private TextView chipFilterManual;
    private TextView chipFilterSafety;

    private LinearLayout layoutBackupsList;
    private TextView tvNoBackups;

    public static String formatCompact(long value) {
        if (value < 0) return "-" + formatCompact(-value);
        if (value < 10000) {
            return NumberFormat.getInstance(Locale.US).format(value);
        }
        if (value < 1000000) {
            double k = value / 1000.0;
            return String.format(Locale.US, "%.1fK", k);
        }
        if (value < 1000000000) {
            double m = value / 1000000.0;
            return String.format(Locale.US, "%.2fM", m);
        }
        double b = value / 1000000000.0;
        return String.format(Locale.US, "%.2fB", b);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveManager = new SaveManager(this);

        initViews();
        checkPermissions();
        handleIncomingIntent(getIntent());
    }

    @Override
    protected void onResume() {
        super.onResume();
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
                    if (is != null) {
                        byte[] buf = new byte[is.available()];
                        is.read(buf);
                        String rawSave = new String(buf);
                        if (!rawSave.trim().isEmpty()) {
                            SaveMetadata meta = new SaveMetadata();
                            meta.isSafetySnapshot = false;
                            meta.customTag = "Shared Import";
                            SaveParser.populateMetadata(meta, rawSave);

                            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
                            File backupFile = new File(saveManager.getBackupsDir(), sdf.format(new java.util.Date()) + "_Shared_Import.json");
                            SaveManager.writeFileDirect(backupFile, meta.toJsonObject().toString());

                            saveManager.writeGameSave(rawSave);
                            Toast.makeText(this, "🎉 Save imported and synced!", Toast.LENGTH_LONG).show();
                        }
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
        tvLiveGoldSub = findViewById(R.id.tv_live_gold_sub);
        tvLiveGems = findViewById(R.id.tv_live_gems);
        tvLiveGemsSub = findViewById(R.id.tv_live_gems_sub);

        layoutUndoBanner = findViewById(R.id.layout_undo_banner);
        btnUndoRestore = findViewById(R.id.btn_undo_restore);

        tvBackupCount = findViewById(R.id.tv_backup_count);
        chipFilterAll = findViewById(R.id.chip_filter_all);
        chipFilterPinned = findViewById(R.id.chip_filter_pinned);
        chipFilterManual = findViewById(R.id.chip_filter_manual);
        chipFilterSafety = findViewById(R.id.chip_filter_safety);

        layoutBackupsList = findViewById(R.id.layout_backups_list);
        tvNoBackups = findViewById(R.id.tv_no_backups);

        TextView tvAppSubtitle = findViewById(R.id.tv_app_subtitle);
        if (tvAppSubtitle != null) {
            try {
                String vName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                if (vName != null && !vName.isEmpty()) {
                    tvAppSubtitle.setText("Companion • Save Manager • v" + vName);
                }
            } catch (Exception ignored) {}
        }

        // Primary actions
        findViewById(R.id.btn_backup_now).setOnClickListener(v -> promptCreateBackup());
        findViewById(R.id.btn_refresh_status).setOnClickListener(v -> refreshAll());
        btnUndoRestore.setOnClickListener(v -> handleUndoRestore());

        // Filter chips
        chipFilterAll.setOnClickListener(v -> setFilter(FilterMode.ALL));
        chipFilterPinned.setOnClickListener(v -> setFilter(FilterMode.PINNED));
        chipFilterManual.setOnClickListener(v -> setFilter(FilterMode.MANUAL));
        chipFilterSafety.setOnClickListener(v -> setFilter(FilterMode.SAFETY));
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

    private void setFilter(FilterMode mode) {
        this.currentFilter = mode;
        updateFilterChipsUI();
        renderBackupsList();
    }

    private void updateFilterChipsUI() {
        chipFilterAll.setBackgroundResource(currentFilter == FilterMode.ALL ? R.drawable.badge_chip_active : R.drawable.badge_chip);
        chipFilterAll.setTextColor(getResources().getColor(currentFilter == FilterMode.ALL ? R.color.gold : R.color.text_gray));

        chipFilterPinned.setBackgroundResource(currentFilter == FilterMode.PINNED ? R.drawable.badge_chip_active : R.drawable.badge_chip);
        chipFilterPinned.setTextColor(getResources().getColor(currentFilter == FilterMode.PINNED ? R.color.gold : R.color.text_gray));

        chipFilterManual.setBackgroundResource(currentFilter == FilterMode.MANUAL ? R.drawable.badge_chip_active : R.drawable.badge_chip);
        chipFilterManual.setTextColor(getResources().getColor(currentFilter == FilterMode.MANUAL ? R.color.gold : R.color.text_gray));

        chipFilterSafety.setBackgroundResource(currentFilter == FilterMode.SAFETY ? R.drawable.badge_chip_active : R.drawable.badge_chip);
        chipFilterSafety.setTextColor(getResources().getColor(currentFilter == FilterMode.SAFETY ? R.color.gold : R.color.text_gray));
    }

    private void refreshAll() {
        saveManager.detectEngine();

        // Update engine badge
        tvEngineBadge.setText(saveManager.getActiveEngine().label);

        // Update active save card
        String liveRaw = saveManager.readGameSave();
        if (liveRaw != null && !liveRaw.trim().isEmpty()) {
            SaveMetadata meta = new SaveMetadata();
            SaveParser.populateMetadata(meta, liveRaw);

            tvCurrentStatus.setText("🟢 Save Detected & Synced");
            layoutCurrentMetrics.setVisibility(View.VISIBLE);

            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            tvLiveHeroes.setText(String.valueOf(meta.heroCount));
            tvLiveGold.setText(formatCompact(meta.gold));
            tvLiveGoldSub.setText("💰 " + nf.format(meta.gold));
            tvLiveGems.setText(formatCompact(meta.gems));
            tvLiveGemsSub.setText("💎 " + nf.format(meta.gems));
        } else {
            tvCurrentStatus.setText("No save detected.\nEnsure Idle Guild Master is installed & played.");
            layoutCurrentMetrics.setVisibility(View.GONE);
        }

        // Persistent Undo check (strictly 1 safety snapshot)
        File safety = saveManager.getLastSafetySnapshot();
        if (safety != null && safety.exists()) {
            layoutUndoBanner.setVisibility(View.VISIBLE);
        } else {
            layoutUndoBanner.setVisibility(View.GONE);
        }

        renderBackupsList();
    }

    private void renderBackupsList() {
        layoutBackupsList.removeAllViews();
        List<File> allFiles = saveManager.listBackupFiles();

        int totalCount = allFiles.size();
        int pinnedCount = 0;
        int safetyCount = 0;
        int manualCount = 0;

        List<File> filteredList = new ArrayList<>();

        for (File file : allFiles) {
            boolean isPinned = file.getName().startsWith("pin_");
            boolean isSafety = file.getName().startsWith("pre_restore_safety") || file.getName().startsWith("pre_");

            if (isPinned) pinnedCount++;
            if (isSafety) safetyCount++;
            else manualCount++;

            switch (currentFilter) {
                case PINNED:
                    if (isPinned) filteredList.add(file);
                    break;
                case SAFETY:
                    if (isSafety) filteredList.add(file);
                    break;
                case MANUAL:
                    if (!isSafety) filteredList.add(file);
                    break;
                case ALL:
                default:
                    filteredList.add(file);
                    break;
            }
        }

        tvBackupCount.setText("BACKUPS (" + totalCount + ")");
        chipFilterAll.setText("All (" + totalCount + ")");
        chipFilterPinned.setText("📌 Pinned (" + pinnedCount + ")");
        chipFilterManual.setText("💾 Manual (" + manualCount + ")");
        chipFilterSafety.setText("🛡️ Safety (" + safetyCount + ")");

        if (filteredList.isEmpty()) {
            tvNoBackups.setVisibility(View.VISIBLE);
            layoutBackupsList.addView(tvNoBackups);
            return;
        }

        tvNoBackups.setVisibility(View.GONE);
        LayoutInflater inflater = LayoutInflater.from(this);

        for (File file : filteredList) {
            View itemView = inflater.inflate(R.layout.item_backup, layoutBackupsList, false);

            TextView btnPin = itemView.findViewById(R.id.btn_backup_pin);
            TextView tvTitle = itemView.findViewById(R.id.tv_backup_title);
            TextView btnRename = itemView.findViewById(R.id.btn_backup_rename);
            TextView tvType = itemView.findViewById(R.id.tv_backup_type);
            TextView tvDate = itemView.findViewById(R.id.tv_backup_date);

            TextView tvHeroes = itemView.findViewById(R.id.tv_backup_heroes);
            TextView tvGold = itemView.findViewById(R.id.tv_backup_gold);
            TextView tvGems = itemView.findViewById(R.id.tv_backup_gems);

            Button btnDelete = itemView.findViewById(R.id.btn_backup_delete);
            Button btnRestore = itemView.findViewById(R.id.btn_backup_restore);

            String content = SaveManager.readFileDirect(file);
            SaveMetadata meta = SaveMetadata.fromJsonString(content);

            boolean isPinned = meta.isPinned || file.getName().startsWith("pin_");
            boolean isSafety = meta.isSafetySnapshot || file.getName().startsWith("pre_restore_safety") || file.getName().startsWith("pre_");

            if (isPinned) {
                btnPin.setText("📌");
                btnPin.setBackgroundResource(R.drawable.badge_chip_active);
            } else {
                btnPin.setText("📍");
                btnPin.setBackgroundResource(R.drawable.btn_icon);
            }

            if (isSafety) {
                tvType.setText("Safety Snapshot");
                tvType.setTextColor(getResources().getColor(R.color.badge_safety_text));
                btnPin.setVisibility(View.GONE);
                btnRename.setVisibility(View.GONE);
            } else if (isPinned) {
                tvType.setText("Pinned");
                tvType.setTextColor(getResources().getColor(R.color.gold));
                btnPin.setVisibility(View.VISIBLE);
                btnRename.setVisibility(View.VISIBLE);
            } else {
                tvType.setText("Manual");
                tvType.setTextColor(getResources().getColor(R.color.accent_blue));
                btnPin.setVisibility(View.VISIBLE);
                btnRename.setVisibility(View.VISIBLE);
            }

            tvTitle.setText(meta.getDisplayTitle());
            tvDate.setText(meta.getFormattedDate() + " • " + file.getName());

            tvHeroes.setText("⚔️ " + meta.heroCount + " Heroes");
            tvGold.setText("💰 " + formatCompact(meta.gold));
            tvGems.setText("💎 " + formatCompact(meta.gems));

            // Pin & Rename in header
            btnPin.setOnClickListener(v -> {
                saveManager.togglePin(file);
                refreshAll();
            });

            btnRename.setOnClickListener(v -> promptRenameBackup(file, meta));

            // Bottom actions
            btnDelete.setOnClickListener(v -> confirmDelete(file));
            btnRestore.setOnClickListener(v -> confirmRestore(file, meta));

            layoutBackupsList.addView(itemView);
        }
    }

    private void promptCreateBackup() {
        EditText input = new EditText(this);
        input.setHint("e.g. Pre-Raid 4, Before Crafting...");
        input.setSingleLine(true);

        new AlertDialog.Builder(this)
            .setTitle("💾 Create Backup")
            .setMessage("Add an optional note/tag for this backup:")
            .setView(input)
            .setPositiveButton("Save with Tag", (d, w) -> {
                String tag = input.getText().toString().trim();
                createBackupInternal(tag);
            })
            .setNeutralButton("Quick Save", (d, w) -> {
                createBackupInternal(null);
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void createBackupInternal(String tag) {
        SaveMetadata meta = saveManager.createBackup(tag, false);
        if (meta != null) {
            Toast.makeText(this, "💾 Backup created successfully!", Toast.LENGTH_SHORT).show();
            refreshAll();
        } else {
            Toast.makeText(this, "❌ Failed to read game save!", Toast.LENGTH_SHORT).show();
        }
    }

    private void promptRenameBackup(File file, SaveMetadata meta) {
        EditText input = new EditText(this);
        input.setText(meta.customTag);
        input.setHint("Enter note/tag...");
        input.setSelection(input.getText().length());
        input.setSingleLine(true);

        new AlertDialog.Builder(this)
            .setTitle("✏️ Rename Backup")
            .setView(input)
            .setPositiveButton("Update", (d, w) -> {
                String newTag = input.getText().toString().trim();
                boolean ok = saveManager.renameBackup(file, newTag);
                if (ok) {
                    Toast.makeText(this, "✅ Tag updated!", Toast.LENGTH_SHORT).show();
                    refreshAll();
                } else {
                    Toast.makeText(this, "❌ Failed to update backup tag!", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("Cancel", null)
            .show();
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

    private void confirmRestore(File file, SaveMetadata meta) {
        NumberFormat nf = NumberFormat.getInstance(Locale.US);

        new AlertDialog.Builder(this)
            .setTitle("🛡️ Restore Backup")
            .setMessage("Restore this save into Idle Guild Master?\n\n"
                + "• Tag: " + meta.getDisplayTitle() + "\n"
                + "• Date: " + meta.getFormattedDate() + "\n"
                + "• Heroes: " + meta.heroCount + "\n"
                + "• Gold: " + nf.format(meta.gold) + " (" + formatCompact(meta.gold) + ")\n"
                + "• Gems: " + nf.format(meta.gems) + "\n\n"
                + "A single safety snapshot will be saved automatically.")
            .setPositiveButton("Restore Now", (d, w) -> {
                boolean ok = saveManager.restoreBackup(file);
                refreshAll();

                if (ok) {
                    Toast.makeText(this, "✅ Save applied to Idle Guild Master!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "❌ Failed to apply save!", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void handleUndoRestore() {
        new AlertDialog.Builder(this)
            .setTitle("↩️ Undo Last Restore")
            .setMessage("Revert game save back to the state before your last restore?")
            .setPositiveButton("Undo Now", (d, w) -> {
                boolean ok = saveManager.undoLastRestore();
                refreshAll();

                if (ok) {
                    Toast.makeText(this, "✅ Reverted to safety snapshot!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "❌ Failed to undo restore!", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("Cancel", null)
            .show();
    }
}
