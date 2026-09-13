package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Upgrade extends Item {
    protected transient int gemPrice;

    public abstract void use();

    public int getGemPrice() {
        return this.gemPrice;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    public int printType() {
        return R.string.type_upgrade;
    }
}
