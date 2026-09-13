package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class StrawberryPancake extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_strawberry_pancake_name;
        this.idDescription = R.string.food_strawberry_pancake_description;
        this.idImage = R.drawable.strawberry_pancake;
        this.price = 8L;
        this.feedPower = 22;
    }
}
