package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class CloakOfRedemption extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_cloak_of_redemption_name;
        this.idDescription = R.string.armor_light_cloak_of_redemption_description;
        this.idEffect = R.string.armor_light_cloak_of_redemption_effect;
        this.idImage = R.drawable.cloak_of_redemption;
        this.price = 4203L;
        this.onFireBonusDamage = 2;
        this.maxHp = Logger.STATUS_FEEBLE_TETHER;
        this.defense = 20;
        this.magicDefense = 10;
    }
}
