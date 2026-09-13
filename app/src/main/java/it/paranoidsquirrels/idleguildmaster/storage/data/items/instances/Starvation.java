package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class Starvation extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_starvation_name;
        this.idDescription = R.string.accessory_starvation_description;
        this.idEffect = R.string.accessory_starvation_effect;
        this.idImage = R.drawable.starvation;
        this.price = 31500L;
        this.intelligence = 5;
        this.lifesteal = 75;
    }
}
