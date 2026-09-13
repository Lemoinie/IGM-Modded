package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class MeatyMushroom extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_meaty_mushroom_name;
        this.idDescription = R.string.food_meaty_mushroom_description;
        this.idImage = R.drawable.meaty_mushroom;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_southern_grove));
        this.price = 5L;
        this.feedPower = 22;
    }
}
