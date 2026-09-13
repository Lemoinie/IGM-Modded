package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class VoidCore extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_void_core_name;
        this.idDescription = R.string.item_void_core_description;
        this.idImage = R.drawable.void_core;
        this.source.add(Integer.valueOf(R.string.raid_name_the_slime_pond));
        this.price = 200L;
    }
}
