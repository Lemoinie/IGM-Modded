package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class BeastmasterJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_beastmaster_jacket_name;
        this.idDescription = R.string.armor_medium_beastmaster_jacket_description;
        this.idEffect = R.string.armor_medium_beastmaster_jacket_effect;
        this.idImage = R.drawable.beastmaster_jacket;
        this.price = 2250L;
        this.maxHp = 220;
        this.constitution = 10;
        this.dexterity = 10;
        this.livingCompanionBonusDamage = 50;
    }
}
