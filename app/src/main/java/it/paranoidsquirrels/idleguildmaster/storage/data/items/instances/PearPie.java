package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class PearPie extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_pear_pie_name;
        this.idDescription = R.string.food_pear_pie_description;
        this.idImage = R.drawable.pear_pie;
        this.price = 51L;
        this.feedPower = 139;
    }
}
