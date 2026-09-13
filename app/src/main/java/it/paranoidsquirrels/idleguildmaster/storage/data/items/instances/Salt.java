package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class Salt extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_salt_name;
        this.idDescription = R.string.food_salt_description;
        this.idImage = R.drawable.salt;
        this.source.add(Integer.valueOf(R.string.dungeon_name_eternal_battlefield));
        this.source.add(Integer.valueOf(R.string.raid_name_ancient_grave_digging));
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_golden_city));
        this.source.add(Integer.valueOf(R.string.raid_name_imperial_rescue));
        this.price = 5L;
        this.feedPower = 1;
    }
}
