package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class FleetfootBoots extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_fleetfoot_boots_name;
        this.idDescription = R.string.accessory_fleetfoot_boots_description;
        this.idEffect = R.string.accessory_fleetfoot_boots_effect;
        this.idImage = R.drawable.fleetfoot_boots;
        this.price = 999L;
        this.flatDodgeChance = 0.16d;
        this.dexterity = 16;
    }
}
