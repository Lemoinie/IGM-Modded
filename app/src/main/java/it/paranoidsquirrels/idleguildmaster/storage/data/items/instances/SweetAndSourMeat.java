package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class SweetAndSourMeat extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_sweet_and_sour_meat_name;
        this.idDescription = R.string.food_sweet_and_sour_meat_description;
        this.idImage = R.drawable.sweet_and_sour_meat;
        this.price = 21L;
        this.feedPower = 38;
    }
}
