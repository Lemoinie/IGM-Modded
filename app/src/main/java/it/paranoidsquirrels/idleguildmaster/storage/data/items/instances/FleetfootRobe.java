package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class FleetfootRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_fleetfoot_robe_name;
        this.idDescription = R.string.armor_light_fleetfoot_robe_description;
        this.idEffect = R.string.armor_light_fleetfoot_robe_effect;
        this.idImage = R.drawable.fleetfoot_robe;
        this.price = 1688L;
        this.flatDodgeChance = 0.24d;
        this.maxHp = 80;
        this.intelligence = 12;
        this.dexterity = 4;
    }
}
