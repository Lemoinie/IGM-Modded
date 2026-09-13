package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class IvoryJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_ivory_jacket_name;
        this.idDescription = R.string.armor_medium_ivory_jacket_description;
        this.idEffect = R.string.armor_medium_ivory_jacket_effect;
        this.idImage = R.drawable.ivory_jacket;
        this.price = 678L;
        this.maxHp = 90;
        this.constitution = 8;
        this.dexterity = 4;
        this.criticalChance = 0.12d;
    }
}
