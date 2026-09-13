package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class PrimordialEssence extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_primordial_essence_name;
        this.idDescription = R.string.item_primordial_essence_description;
        this.idImage = R.drawable.primordial_essence;
        this.source.add(Integer.valueOf(R.string.dungeon_name_enchanted_forest));
        this.price = 30L;
    }
}
