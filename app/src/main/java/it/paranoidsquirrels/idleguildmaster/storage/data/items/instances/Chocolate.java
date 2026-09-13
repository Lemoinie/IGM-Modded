package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class Chocolate extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_chocolate_name;
        this.idDescription = R.string.food_chocolate_description;
        this.idImage = R.drawable.chocolate;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_golden_city));
        this.source.add(Integer.valueOf(R.string.raid_name_imperial_rescue));
        this.price = 10L;
        this.feedPower = 20;
    }
}
