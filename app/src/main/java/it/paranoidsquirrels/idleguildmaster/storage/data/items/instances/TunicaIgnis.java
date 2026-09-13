package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class TunicaIgnis extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_tunica_ignis_name;
        this.idDescription = R.string.armor_light_tunica_ignis_description;
        this.idEffect = R.string.armor_light_tunica_ignis_effect;
        this.idImage = R.drawable.tunica_ignis;
        this.price = 2370L;
        this.onFireBonusDamage = 2;
        this.maxHp = 100;
        this.defense = 10;
    }
}
