package it.paranoidsquirrels.idleguildmaster.storage.data.items;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Item {
    private static final transient String CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.%s";
    protected transient int idDescription;
    protected transient int idEffect;
    protected transient int idImage;
    protected transient int idName;
    protected transient long price;
    protected transient int rarity;
    protected transient List<Integer> source;
    protected int stack;
    protected String trueClass;
    protected transient String uniqueOrigin = null;
    protected transient boolean notSellable = false;
    protected transient boolean consumable = false;

    protected abstract void configureProperties();

    public static Item getInstance(String str) {
        return getInstance(str, 1);
    }

    public static Item getInstance(String str, int i) {
        try {
            Item item = (Item) Class.forName(String.format(CLASS_PATH, str)).getConstructor(new Class[0]).newInstance(new Object[0]);
            item.trueClass = str;
            item.stack = i;
            item.source = new LinkedList();
            item.configureProperties();
            return item;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Item) {
            return this.trueClass.equals(((Item) obj).trueClass);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.trueClass);
    }

    public long getSecondsToCraft() {
        return (long) ((MainActivity.data.isMerchantPackPurchased() ? 0.6d : 1.0d) * Math.pow(0.9d, (MainActivity.data.getLevelWorkshopTime() + MainActivity.data.getUpgradeWorkshopTime()) - 1) * Math.max(this.price - 1, 1L) * 6 * ((double) this.stack));
    }

    public long getSecondsToSell() {
        return (long) ((MainActivity.data.isMerchantPackPurchased() ? 0.6d : 1.0d) * Math.pow(0.9d, (MainActivity.data.getLevelMarketTime() + MainActivity.data.getUpgradeMarketTime()) - 1) * this.price * 4 * ((double) this.stack));
    }

    public String getTrueClass() {
        return this.trueClass;
    }

    public void setTrueClass(String str) {
        this.trueClass = str;
    }

    public int getIdName() {
        return this.idName;
    }

    public void setIdName(int i) {
        this.idName = i;
    }

    public int getIdDescription() {
        return this.idDescription;
    }

    public void setIdDescription(int i) {
        this.idDescription = i;
    }

    public List<Integer> getSource() {
        return this.source;
    }

    public void setSource(List<Integer> list) {
        this.source = list;
    }

    public int getIdEffect() {
        return this.idEffect;
    }

    public void setIdEffect(int i) {
        this.idEffect = i;
    }

    public int getIdImage() {
        return this.idImage;
    }

    public void setIdImage(int i) {
        this.idImage = i;
    }

    public int getStack() {
        return this.stack;
    }

    public void setStack(int i) {
        this.stack = i;
    }

    public long getPrice() {
        return Utils.truncatePrice(this.price);
    }

    public void setPrice(long j) {
        this.price = j;
    }

    public int getRarity() {
        return this.rarity;
    }

    public void setRarity(int i) {
        this.rarity = i;
    }

    public String getUniqueOrigin() {
        return this.uniqueOrigin;
    }

    public void setUniqueOrigin(String str) {
        this.uniqueOrigin = str;
    }

    public boolean isNotSellable() {
        return this.notSellable;
    }

    public void setNotSellable(boolean z) {
        this.notSellable = z;
    }

    public int printType() {
        return R.string.type_material;
    }

    public boolean isConsumable() {
        return this.consumable;
    }

    public void setConsumable(boolean z) {
        this.consumable = z;
    }
}
