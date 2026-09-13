package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class IgnitionOrb extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_ignition_orb_name;
        this.idDescription = R.string.accessory_ignition_orb_description;
        this.idEffect = R.string.accessory_ignition_orb_effect;
        this.idImage = R.drawable.ignition_orb;
        this.price = 657L;
        this.onFireBonusDamage = 2;
        this.maxHp = 70;
        this.intelligence = 8;
    }
}
