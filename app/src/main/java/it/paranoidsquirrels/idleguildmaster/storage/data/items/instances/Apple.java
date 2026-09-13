package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class Apple extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_apple_name;
        this.idDescription = R.string.food_apple_description;
        this.idImage = R.drawable.apple;
        this.source.add(Integer.valueOf(R.string.dungeon_name_enchanted_forest));
        this.price = 1L;
        this.feedPower = 4;
    }
}
