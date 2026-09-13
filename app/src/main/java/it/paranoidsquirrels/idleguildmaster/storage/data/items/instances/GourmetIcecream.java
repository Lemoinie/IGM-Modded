package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class GourmetIcecream extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_gourmet_icecream_name;
        this.idDescription = R.string.food_gourmet_icecream_description;
        this.idImage = R.drawable.gourmet_icecream;
        this.price = 100L;
        this.feedPower = 1350;
    }
}
