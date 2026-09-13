package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class BansheeScale extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_banshee_scale_name;
        this.idDescription = R.string.item_banshee_scale_description;
        this.idImage = R.drawable.banshee_scale;
        this.source.add(Integer.valueOf(R.string.dungeon_name_barren_wastelands));
        this.price = 3L;
    }
}
