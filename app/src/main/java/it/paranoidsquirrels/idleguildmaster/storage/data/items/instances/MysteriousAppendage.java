package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class MysteriousAppendage extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_mysterious_appendage_name;
        this.idDescription = R.string.item_mysterious_appendage_description;
        this.idImage = R.drawable.mysterious_appendage;
        this.source.add(Integer.valueOf(R.string.dungeon_name_blackwater_port));
        this.price = 15L;
    }
}
