package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class SunfireEssence extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_sunfire_essence_name;
        this.idDescription = R.string.item_sunfire_essence_description;
        this.idImage = R.drawable.sunfire_essence;
        this.price = 950L;
    }
}
