package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class MutantJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_mutant_jacket_name;
        this.idDescription = R.string.armor_medium_mutant_jacket_description;
        this.idImage = R.drawable.mutant_jacket;
        this.price = 2280L;
        this.maxHp = 316;
        this.constitution = 6;
        this.dexterity = 6;
    }
}
