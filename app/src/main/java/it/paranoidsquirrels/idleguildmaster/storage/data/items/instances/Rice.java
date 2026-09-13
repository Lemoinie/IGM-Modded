package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class Rice extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_rice_name;
        this.idDescription = R.string.food_rice_description;
        this.idImage = R.drawable.rice;
        this.source.add(Integer.valueOf(R.string.dungeon_name_eternal_battlefield));
        this.source.add(Integer.valueOf(R.string.raid_name_ancient_grave_digging));
        this.source.add(Integer.valueOf(R.string.dungeon_name_frostbite_peaks));
        this.price = 1L;
        this.feedPower = 3;
    }
}
