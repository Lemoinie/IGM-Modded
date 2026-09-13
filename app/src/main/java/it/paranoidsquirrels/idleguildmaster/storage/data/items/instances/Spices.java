package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class Spices extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_spices_name;
        this.idDescription = R.string.food_spices_description;
        this.idImage = R.drawable.spices;
        this.source.add(Integer.valueOf(R.string.dungeon_name_enchanted_forest));
        this.price = 3L;
        this.feedPower = 1;
    }
}
