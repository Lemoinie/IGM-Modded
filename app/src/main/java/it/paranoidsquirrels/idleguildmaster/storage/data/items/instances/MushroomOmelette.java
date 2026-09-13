package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class MushroomOmelette extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_mushroom_omelette_name;
        this.idDescription = R.string.food_mushroom_omelette_description;
        this.idImage = R.drawable.mushroom_omelette;
        this.price = 17L;
        this.feedPower = 41;
    }
}
