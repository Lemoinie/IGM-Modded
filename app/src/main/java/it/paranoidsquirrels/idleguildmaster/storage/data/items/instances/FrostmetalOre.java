package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class FrostmetalOre extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_frostmetal_ore_name;
        this.idDescription = R.string.item_frostmetal_ore_description;
        this.idImage = R.drawable.frostmetal_ore;
        this.source.add(Integer.valueOf(R.string.dungeon_name_frostbite_peaks));
        this.price = 4L;
    }
}
