package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class FrozenBreathBroth extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_frozen_breath_broth_name;
        this.idDescription = R.string.food_frozen_breath_broth_description;
        this.idImage = R.drawable.frozen_breath_broth;
        this.price = 41L;
        this.feedPower = 219;
    }
}
