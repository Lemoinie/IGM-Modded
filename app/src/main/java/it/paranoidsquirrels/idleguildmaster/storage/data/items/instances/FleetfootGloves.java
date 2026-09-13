package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class FleetfootGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_fleetfoot_gloves_name;
        this.idDescription = R.string.accessory_fleetfoot_gloves_description;
        this.idEffect = R.string.accessory_fleetfoot_gloves_effect;
        this.idImage = R.drawable.fleetfoot_gloves;
        this.price = 1031L;
        this.flatDodgeChance = 0.16d;
        this.constitution = 10;
        this.dexterity = 12;
    }
}
