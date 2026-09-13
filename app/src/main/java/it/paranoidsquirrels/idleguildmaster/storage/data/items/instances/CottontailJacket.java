package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class CottontailJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_cottontail_jacket_name;
        this.idDescription = R.string.armor_medium_cottontail_jacket_description;
        this.idEffect = R.string.armor_medium_cottontail_jacket_effect;
        this.idImage = R.drawable.cottontail_jacket;
        this.price = 345L;
        this.maxHp = 20;
        this.constitution = 1;
        this.dexterity = 1;
        this.bonusExperience = 35;
    }
}
