package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class MeatChop extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_meat_chop_name;
        this.idDescription = R.string.food_meat_chop_description;
        this.idImage = R.drawable.meat_chop;
        this.source.add(Integer.valueOf(R.string.dungeon_name_enchanted_forest));
        this.price = 2L;
        this.feedPower = 10;
    }
}
