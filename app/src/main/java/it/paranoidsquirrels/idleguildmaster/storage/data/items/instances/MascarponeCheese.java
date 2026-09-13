package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class MascarponeCheese extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_mascarpone_cheese_name;
        this.idDescription = R.string.food_mascarpone_cheese_description;
        this.idImage = R.drawable.mascarpone_cheese;
        this.price = 59L;
        this.feedPower = 143;
    }
}
