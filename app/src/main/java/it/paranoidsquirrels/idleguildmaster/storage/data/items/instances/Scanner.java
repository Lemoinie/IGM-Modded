package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class Scanner extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_scanner_name;
        this.idDescription = R.string.item_scanner_description;
        this.idImage = R.drawable.scanner;
        this.source.add(Integer.valueOf(R.string.dungeon_name_barren_wastelands));
        this.source.add(Integer.valueOf(R.string.raid_name_celestial_mothership));
        this.price = 90L;
    }
}
