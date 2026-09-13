package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class BansheeHorn extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_banshee_horn_name;
        this.idDescription = R.string.item_banshee_horn_description;
        this.idImage = R.drawable.banshee_horn;
        this.source.add(Integer.valueOf(R.string.dungeon_name_barren_wastelands));
        this.price = 95L;
    }
}
