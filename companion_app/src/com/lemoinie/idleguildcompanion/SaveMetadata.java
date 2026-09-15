package com.lemoinie.idleguildcompanion;

import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SaveMetadata {
    public int version = 1;
    public String createdAt;
    public String gameVersion = "1.0.0";
    public long gold = 0;
    public int gems = 0;
    public int guildLevel = 1;
    public int heroCount = 0;
    public String save = "";
    public boolean isSafetySnapshot = false;

    public SaveMetadata() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        this.createdAt = sdf.format(new Date());
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
            obj.put("heroCount", heroCount);
            obj.put("isSafetySnapshot", isSafetySnapshot);
            obj.put("save", save);
        } catch (Exception ignored) {}
        return obj;
    }

    public static SaveMetadata fromJsonString(String jsonStr) {
        SaveMetadata meta = new SaveMetadata();
        try {
            JSONObject obj = new JSONObject(jsonStr);
            meta.version = obj.optInt("version", 1);
            meta.createdAt = obj.optString("createdAt", meta.createdAt);
            meta.gameVersion = obj.optString("gameVersion", "1.0.0");
            meta.gold = obj.optLong("gold", 0);
            meta.gems = obj.optInt("gems", 0);
            meta.guildLevel = obj.optInt("guildLevel", 1);
            meta.heroCount = obj.optInt("heroCount", 0);
            meta.isSafetySnapshot = obj.optBoolean("isSafetySnapshot", false);
            meta.save = obj.optString("save", "");
            
            // If it's a raw save file without metadata wrapper:
            if (meta.save.isEmpty() && obj.has("adventurers")) {
                meta.save = jsonStr;
                SaveParser.populateMetadata(meta, jsonStr);
            }
        } catch (Exception e) {
            // Raw text or non-JSON save:
            meta.save = jsonStr;
            SaveParser.populateMetadata(meta, jsonStr);
        }
        return meta;
    }
}
