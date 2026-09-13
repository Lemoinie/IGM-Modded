package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SpellwovenJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_spellwoven_jacket_name;
        this.idDescription = R.string.armor_medium_spellwoven_jacket_description;
        this.idImage = R.drawable.spellwoven_jacket;
        this.price = 741L;
        this.maxHp = 200;
        this.constitution = 10;
        this.dexterity = 10;
    }
}
