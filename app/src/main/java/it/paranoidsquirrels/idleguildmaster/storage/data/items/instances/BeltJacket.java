package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class BeltJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_belt_jacket_name;
        this.idDescription = R.string.armor_medium_belt_jacket_description;
        this.idImage = R.drawable.belt_jacket;
        this.price = 312L;
        this.maxHp = 80;
        this.constitution = 4;
        this.dexterity = 4;
    }
}
