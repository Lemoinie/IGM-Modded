package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class BlackIronScraps extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_black_iron_scraps_name;
        this.idDescription = R.string.item_black_iron_scraps_description;
        this.idImage = R.drawable.black_iron_scraps;
        this.source.add(Integer.valueOf(R.string.dungeon_name_blackwater_port));
        this.price = 3L;
    }
}
