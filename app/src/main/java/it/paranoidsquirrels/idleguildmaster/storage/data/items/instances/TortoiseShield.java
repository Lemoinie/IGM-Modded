package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class TortoiseShield extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_tortoise_shield_name;
        this.idDescription = R.string.accessory_tortoise_shield_description;
        this.idImage = R.drawable.tortoise_shield;
        this.price = 240L;
        this.constitution = 24;
    }
}
