package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SageJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_sage_jacket_name;
        this.idDescription = R.string.armor_medium_sage_jacket_description;
        this.idEffect = R.string.armor_medium_sage_jacket_effect;
        this.idImage = R.drawable.sage_jacket;
        this.price = 3465L;
        this.maxHp = 140;
        this.constitution = 7;
        this.dexterity = 7;
        this.bonusExperience = 60;
    }
}
