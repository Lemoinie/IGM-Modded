package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class CeremonialCake extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_ceremonial_cake_name;
        this.idDescription = R.string.food_ceremonial_cake_description;
        this.idImage = R.drawable.ceremonial_cake;
        this.price = 2200L;
        this.feedPower = 30000;
    }
}
