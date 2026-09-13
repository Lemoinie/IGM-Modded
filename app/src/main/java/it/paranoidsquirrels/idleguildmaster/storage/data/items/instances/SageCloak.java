package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SageCloak extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_sage_cloak_name;
        this.idDescription = R.string.armor_light_sage_cloak_description;
        this.idEffect = R.string.armor_light_sage_cloak_effect;
        this.idImage = R.drawable.sage_cloak;
        this.price = 3533L;
        this.maxHp = 70;
        this.intelligence = 21;
        this.bonusExperience = 60;
    }
}
