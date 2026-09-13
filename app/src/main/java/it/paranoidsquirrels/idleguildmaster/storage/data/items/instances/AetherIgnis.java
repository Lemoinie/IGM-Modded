package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class AetherIgnis extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_aether_ignis_name;
        this.idDescription = R.string.item_aether_ignis_description;
        this.idImage = R.drawable.aether_ignis;
        this.source.add(Integer.valueOf(R.string.dungeon_name_barren_wastelands));
        this.source.add(Integer.valueOf(R.string.raid_name_celestial_mothership));
        this.price = 19L;
    }
}
