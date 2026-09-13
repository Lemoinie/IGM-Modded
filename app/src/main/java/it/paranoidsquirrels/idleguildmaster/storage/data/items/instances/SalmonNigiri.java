package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class SalmonNigiri extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_salmon_nigiri_name;
        this.idDescription = R.string.food_salmon_nigiri_description;
        this.idImage = R.drawable.salmon_nigiri;
        this.price = 18L;
        this.feedPower = 54;
    }
}
