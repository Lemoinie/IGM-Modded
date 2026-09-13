package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class SharpRib extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_sharp_rib_name;
        this.idDescription = R.string.item_sharp_rib_description;
        this.idImage = R.drawable.sharp_rib;
        this.source.add(Integer.valueOf(R.string.dungeon_name_eternal_battlefield));
        this.source.add(Integer.valueOf(R.string.raid_name_ancient_grave_digging));
        this.price = 6L;
    }
}
