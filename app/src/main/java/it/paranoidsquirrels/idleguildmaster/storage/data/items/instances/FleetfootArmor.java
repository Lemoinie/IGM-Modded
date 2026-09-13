package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class FleetfootArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_fleetfoot_armor_name;
        this.idDescription = R.string.armor_heavy_fleetfoot_armor_description;
        this.idEffect = R.string.armor_heavy_fleetfoot_armor_effect;
        this.idImage = R.drawable.fleetfoot_armor;
        this.price = 1251L;
        this.flatDodgeChance = 0.12d;
        this.maxHp = 240;
        this.constitution = 5;
        this.dexterity = 1;
    }
}
