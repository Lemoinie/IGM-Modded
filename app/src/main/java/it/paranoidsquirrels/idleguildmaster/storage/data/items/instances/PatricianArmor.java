package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class PatricianArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_patrician_armor_name;
        this.idDescription = R.string.armor_heavy_patrician_armor_description;
        this.idEffect = R.string.armor_heavy_patrician_armor_effect;
        this.idImage = R.drawable.patrician_armor;
        this.price = 645L;
        this.maxHp = Logger.BARD_SHIELD;
        this.constitution = 4;
        this.bonusExperience = 35;
    }
}
