package it.paranoidsquirrels.idleguildmaster.storage.data.items;

/* JADX INFO: loaded from: classes3.dex */
public class ItemWrapper {
    private Item item;

    public static ItemWrapper getInstance(String str) {
        return getInstance(str, 1);
    }

    public static ItemWrapper getInstance(String str, int i) {
        ItemWrapper itemWrapper = new ItemWrapper();
        itemWrapper.item = Item.getInstance(str, i);
        return itemWrapper;
    }

    private ItemWrapper() {
    }

    public Item getItem() {
        return this.item;
    }
}
