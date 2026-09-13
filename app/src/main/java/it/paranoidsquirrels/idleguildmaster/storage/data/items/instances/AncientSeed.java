package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class AncientSeed extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_ancient_seed_name;
        this.idDescription = R.string.item_ancient_seed_description;
        this.idImage = R.drawable.ancient_seed;
        this.source.add(Integer.valueOf(R.string.dungeon_name_enchanted_forest));
        this.price = 20L;
    }
}
