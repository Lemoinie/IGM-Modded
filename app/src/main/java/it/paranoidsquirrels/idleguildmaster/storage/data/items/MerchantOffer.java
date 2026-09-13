package it.paranoidsquirrels.idleguildmaster.storage.data.items;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class MerchantOffer {
    private boolean gems;
    private Item item;
    private long price;

    public MerchantOffer(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getPrice() {
        return this.price;
    }

    public void setPrice(long j) {
        this.price = j;
    }

    public boolean isGems() {
        return this.gems;
    }

    public void setGems(boolean z) {
        this.gems = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantOffer)) {
            return false;
        }
        MerchantOffer merchantOffer = (MerchantOffer) obj;
        return this.price == merchantOffer.price && this.gems == merchantOffer.gems && this.item.equals(merchantOffer.item);
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.price), Boolean.valueOf(this.gems), this.item);
    }
}
