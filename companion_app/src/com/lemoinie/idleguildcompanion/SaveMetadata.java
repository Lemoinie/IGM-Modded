package com.lemoinie.idleguildcompanion;

import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SaveMetadata {
    public int version = 2;
    public String createdAt;
    public String gameVersion = "1.1.0";
    public long gold = 0;
    public int gems = 0;
    public int guildLevel = 1;
    public int quartersLevel = 0;
    public int maxTier = 0;
    public int heroCount = 0;
    public String customTag = "";
    public boolean isPinned = false;
    public boolean isSafetySnapshot = false;
    public String targetPackage = "";
    public String save = "";

    public SaveMetadata() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        this.createdAt = sdf.format(new Date());
    }

    public String getFormattedDate() {
        if (createdAt == null || createdAt.trim().isEmpty()) {
            return "";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            Date date = sdf.parse(createdAt);
            if (date != null) {
                long now = System.currentTimeMillis();
                long time = date.getTime();
                long diff = now - time;

                SimpleDateFormat timeFmt = new SimpleDateFormat("h:mm a", Locale.US);
                SimpleDateFormat dayFmt = new SimpleDateFormat("yyyyMMdd", Locale.US);

                String dateDay = dayFmt.format(date);
                String todayDay = dayFmt.format(new Date(now));
                String yesterdayDay = dayFmt.format(new Date(now - 24L * 3600L * 1000L));

                if (todayDay.equals(dateDay)) {
                    return "Today at " + timeFmt.format(date);
                } else if (yesterdayDay.equals(dateDay)) {
                    return "Yesterday at " + timeFmt.format(date);
                } else {
                    SimpleDateFormat fullFmt = new SimpleDateFormat("MMM d, yyyy • h:mm a", Locale.US);
                    return fullFmt.format(date);
                }
            }
        } catch (Exception ignored) {}
        return createdAt;
    }

    public String getDisplayTitle() {
        if (customTag != null && !customTag.trim().isEmpty()) {
            return customTag.trim();
        }
        return getFormattedDate();
    }

    public JSONObject toJsonObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("version", version);
            obj.put("createdAt", createdAt);
            obj.put("gameVersion", gameVersion);
            obj.put("gold", gold);
            obj.put("gems", gems);
            obj.put("guildLevel", guildLevel);
            obj.put("quartersLevel", quartersLevel);
            obj.put("maxTier", maxTier);
            obj.put("heroCount", heroCount);
            obj.put("customTag", customTag != null ? customTag : "");
            obj.put("isPinned", isPinned);
            obj.put("isSafetySnapshot", isSafetySnapshot);
            obj.put("targetPackage", targetPackage != null ? targetPackage : "");
            obj.put("save", save);
        } catch (Exception ignored) {}
        return obj;
    }

    public static SaveMetadata fromJsonString(String jsonStr) {
        SaveMetadata meta = new SaveMetadata();
        if (jsonStr == null || jsonStr.trim().isEmpty()) {
            return meta;
        }

        try {
            JSONObject obj = new JSONObject(jsonStr);
            meta.version = obj.optInt("version", 2);
            meta.createdAt = obj.optString("createdAt", meta.createdAt);
            meta.gameVersion = obj.optString("gameVersion", "1.0.0");
            
            // Support both "money" (vanilla save schema) and "gold"
            if (obj.has("money")) {
                meta.gold = obj.optLong("money", 0);
            } else {
                meta.gold = obj.optLong("gold", 0);
            }

            meta.gems = obj.optInt("gems", 0);
            meta.guildLevel = obj.optInt("guildLevel", 1);
            meta.quartersLevel = obj.optInt("quartersLevel", 0);
            meta.maxTier = obj.optInt("maxTier", 0);
            meta.heroCount = obj.optInt("heroCount", 0);
            meta.customTag = obj.optString("customTag", "");
            meta.isPinned = obj.optBoolean("isPinned", false);
            meta.isSafetySnapshot = obj.optBoolean("isSafetySnapshot", false);
            meta.targetPackage = obj.optString("targetPackage", "");
            meta.save = obj.optString("save", "");

            // If it's a raw save file without metadata wrapper:
            if (meta.save.isEmpty() && (obj.has("adventurers") || obj.has("money") || obj.has("lastAccess"))) {
                meta.save = jsonStr;
                SaveParser.populateMetadata(meta, jsonStr);
            } else if (!meta.save.isEmpty() && (meta.gold == 0 || meta.quartersLevel == 0 || meta.maxTier == 0)) {
                // Backward-compatibility: 1.0.0 backups had "gold": 0 in the wrapper due to the
                // old key bug and lacked quartersLevel/maxTier. Re-populate from the inner save!
                SaveParser.populateMetadata(meta, meta.save);
            }
        } catch (Exception e) {
            // Raw text or fallback:
            meta.save = jsonStr;
            SaveParser.populateMetadata(meta, jsonStr);
        }
        return meta;
    }
}
