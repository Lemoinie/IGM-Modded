package it.paranoidsquirrels.idleguildmaster.storage.data.quests;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Quest {
    private static final transient String CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances.%s";
    public static final transient int RARITY_COMMON = 1;
    public static final transient int RARITY_EPIC = 4;
    public static final transient int RARITY_RARE = 3;
    public static final transient int RARITY_UNCOMMON = 2;
    protected transient boolean active;
    protected transient int defaultRarity;
    protected transient int idDescription;
    protected transient int idName;
    protected transient int minimumDifficulty;
    protected long progress;
    protected int rarity;
    protected long targetProgress;
    protected String trueClass;

    protected abstract void calculateTargetProgress(int i);

    public Quest cannotAppearWith() {
        return null;
    }

    protected abstract void configure();

    public abstract void realignStaticReference();

    public static Quest createInstance(String str, int i, int i2, int i3) {
        Quest quest = getInstance(str, i, i3);
        if (quest == null) {
            return null;
        }
        quest.calculateTargetProgress(i2);
        return quest;
    }

    public static Quest loadInstance(String str, int i, int i2, int i3) {
        Quest quest = getInstance(str, i, i3);
        if (quest == null) {
            return null;
        }
        quest.targetProgress = i2;
        quest.activate();
        return quest;
    }

    private static Quest getInstance(String str, int i, int i2) {
        try {
            Quest quest = (Quest) Class.forName(String.format(CLASS_PATH, str)).getConstructor(new Class[0]).newInstance(new Object[0]);
            quest.trueClass = str;
            if (i == 0) {
                i = quest.defaultRarity;
            }
            quest.rarity = i;
            quest.progress = i2;
            quest.active = false;
            quest.configure();
            return quest;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTrueClass() {
        return this.trueClass;
    }

    public long getProgress() {
        return this.progress;
    }

    public void setProgress(long j) {
        this.progress = j;
    }

    public long getTargetProgress() {
        return this.targetProgress;
    }

    public int getRarity() {
        return this.rarity;
    }

    public void setRarity(int i) {
        this.rarity = i;
    }

    public int getIdName() {
        return this.idName;
    }

    public int getIdDescription() {
        return this.idDescription;
    }

    public int getDefaultRarity() {
        return this.defaultRarity;
    }

    public int getMinimumDifficulty() {
        return this.minimumDifficulty;
    }

    public boolean isActive() {
        return this.active;
    }

    public void activate() {
        this.active = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Quest) {
            return this.trueClass.equals(((Quest) obj).trueClass);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.trueClass);
    }
}
