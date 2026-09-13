package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class CursedJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_cursed_jacket_name;
        this.idDescription = R.string.armor_medium_cursed_jacket_description;
        this.idEffect = R.string.armor_medium_cursed_jacket_effect;
        this.idImage = R.drawable.cursed_jacket;
        this.price = 1440L;
        this.maxHp = 100;
        this.constitution = 10;
        this.criticalDamage = 0.5d;
    }
}
