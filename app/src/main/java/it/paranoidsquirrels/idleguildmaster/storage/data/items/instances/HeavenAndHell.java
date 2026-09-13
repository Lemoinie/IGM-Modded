package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class HeavenAndHell extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_heaven_and_hell_name;
        this.idDescription = R.string.food_heaven_and_hell_description;
        this.idImage = R.drawable.heaven_and_hell;
        this.price = 167L;
        this.feedPower = 362;
    }
}
