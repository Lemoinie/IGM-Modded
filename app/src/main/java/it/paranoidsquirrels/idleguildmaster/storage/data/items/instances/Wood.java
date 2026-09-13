package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class Wood extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_wood_name;
        this.idDescription = R.string.item_wood_description;
        this.idImage = R.drawable.wood;
        this.source.add(Integer.valueOf(R.string.dungeon_name_enchanted_forest));
        this.price = 1L;
    }
}
