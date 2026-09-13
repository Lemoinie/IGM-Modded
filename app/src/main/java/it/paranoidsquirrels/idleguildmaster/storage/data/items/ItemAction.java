package it.paranoidsquirrels.idleguildmaster.storage.data.items;

/* JADX INFO: loaded from: classes3.dex */
public class ItemAction {
    private Item item;
    private long secondsPassed;

    public ItemAction(Item item) {
        this.item = item;
    }

    public long getSecondsPassed() {
        return this.secondsPassed;
    }

    public void setSecondsPassed(long j) {
        this.secondsPassed = j;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
