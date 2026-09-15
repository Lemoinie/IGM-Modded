package com.lemoinie.idleguildcompanion;

import org.json.JSONArray;
import org.json.JSONObject;

public class SaveParser {

    public static boolean populateMetadata(SaveMetadata meta, String rawSave) {
        if (rawSave == null || rawSave.trim().isEmpty()) {
            return false;
        }

        try {
            String trimmed = rawSave.trim();
            if (trimmed.startsWith("{")) {
                JSONObject obj = new JSONObject(trimmed);

                // In case rawSave was a wrapped metadata container
                if (obj.has("save") && obj.has("heroCount")) {
                    meta.gold = obj.optLong("gold", meta.gold);
                    meta.gems = obj.optInt("gems", meta.gems);
                    meta.guildLevel = obj.optInt("guildLevel", meta.guildLevel);
                    meta.heroCount = obj.optInt("heroCount", meta.heroCount);
                    meta.save = obj.optString("save", rawSave);
                    return true;
                }

                // Raw game data.txt schema
                meta.gold = obj.optLong("gold", 0);
                meta.gems = obj.optInt("gems", 0);
                
                JSONArray adventurers = obj.optJSONArray("adventurers");
                if (adventurers != null) {
                    meta.heroCount = adventurers.length();
                }

                if (obj.has("guildLevel")) {
                    meta.guildLevel = obj.optInt("guildLevel", 1);
                }

                meta.save = rawSave;
                return true;
            }
        } catch (Exception ignored) {}

        // Fallback for non-JSON or custom format
        meta.save = rawSave;
        return false;
    }

    public static String extractRawGameSave(String content) {
        if (content == null) return "";
        try {
            JSONObject obj = new JSONObject(content);
            if (obj.has("save")) {
                String inner = obj.getString("save");
                if (!inner.isEmpty()) return inner;
            }
        } catch (Exception ignored) {}
        return content;
    }
}
