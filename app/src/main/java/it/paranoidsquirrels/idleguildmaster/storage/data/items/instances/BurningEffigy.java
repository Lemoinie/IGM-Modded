package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class BurningEffigy extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_burning_effigy_name;
        this.idDescription = R.string.accessory_burning_effigy_description;
        this.idEffect = R.string.accessory_burning_effigy_effect;
        this.idImage = R.drawable.burning_effigy;
        this.price = 43598L;
        this.constitution = 34;
        this.defense = 9;
        this.magicDefense = 9;
        this.threat = 3;
    }
}
