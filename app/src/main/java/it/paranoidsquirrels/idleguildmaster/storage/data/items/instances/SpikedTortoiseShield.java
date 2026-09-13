package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SpikedTortoiseShield extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_spiked_tortoise_shield_name;
        this.idDescription = R.string.accessory_spiked_tortoise_shield_description;
        this.idEffect = R.string.accessory_spiked_tortoise_shield_effect;
        this.idImage = R.drawable.spiked_tortoise_shield;
        this.price = 846L;
        this.retaliationPhysicalDamage = 25;
        this.constitution = 24;
    }
}
