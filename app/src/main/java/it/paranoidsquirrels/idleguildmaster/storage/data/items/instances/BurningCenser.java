package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class BurningCenser extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_burning_censer_name;
        this.idDescription = R.string.accessory_burning_censer_description;
        this.idEffect = R.string.accessory_burning_censer_effect;
        this.idImage = R.drawable.burning_censer;
        this.price = 564L;
        this.intelligence = 12;
        this.darknessReduction = 10;
        this.healingModifier = 0.2d;
    }
}
