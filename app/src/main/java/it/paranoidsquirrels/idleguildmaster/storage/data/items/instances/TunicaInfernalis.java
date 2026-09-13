package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class TunicaInfernalis extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_tunica_infernalis_name;
        this.idDescription = R.string.armor_light_tunica_infernalis_description;
        this.idEffect = R.string.armor_light_tunica_infernalis_effect;
        this.idImage = R.drawable.tunica_infernalis;
        this.price = 7205L;
        this.onFireBonusDamage = 2;
        this.maxHp = 150;
        this.defense = 20;
        this.magicDefense = 12;
    }
}
