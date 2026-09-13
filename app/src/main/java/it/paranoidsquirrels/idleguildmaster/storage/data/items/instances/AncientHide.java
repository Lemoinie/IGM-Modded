package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class AncientHide extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_ancient_hide_name;
        this.idDescription = R.string.item_ancient_hide_description;
        this.idImage = R.drawable.ancient_hide;
        this.source.add(Integer.valueOf(R.string.dungeon_name_lost_lands));
        this.price = 2L;
    }
}
