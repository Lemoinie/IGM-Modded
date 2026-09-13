package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class PastaWithSauce extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_pasta_with_sauce_name;
        this.idDescription = R.string.food_pasta_with_sauce_description;
        this.idImage = R.drawable.pasta_with_sauce;
        this.price = 66L;
        this.feedPower = 173;
    }
}
