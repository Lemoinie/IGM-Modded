package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class FleetfootJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_fleetfoot_jacket_name;
        this.idDescription = R.string.armor_medium_fleetfoot_jacket_description;
        this.idEffect = R.string.armor_medium_fleetfoot_jacket_effect;
        this.idImage = R.drawable.fleetfoot_jacket;
        this.price = 945L;
        this.flatDodgeChance = 0.2d;
        this.maxHp = 160;
        this.constitution = 4;
        this.dexterity = 8;
    }
}
