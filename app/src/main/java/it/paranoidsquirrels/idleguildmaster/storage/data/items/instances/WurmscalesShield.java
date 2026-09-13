package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class WurmscalesShield extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_wurmscales_shield_name;
        this.idDescription = R.string.accessory_wurmscales_shield_description;
        this.idImage = R.drawable.wurmscales_shield;
        this.price = 35L;
        this.constitution = 6;
    }
}
