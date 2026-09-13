package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class ExoticFruitSalad extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_exotic_fruit_salad_name;
        this.idDescription = R.string.food_exotic_fruit_salad_description;
        this.idImage = R.drawable.exotic_fruit_salad;
        this.price = 23L;
        this.feedPower = 46;
    }
}
