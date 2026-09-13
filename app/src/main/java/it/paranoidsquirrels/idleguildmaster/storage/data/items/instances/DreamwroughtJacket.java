package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_dreamwrought_jacket_name;
        this.idDescription = R.string.armor_medium_dreamwrought_jacket_description;
        this.idImage = R.drawable.dreamwrought_jacket;
        this.price = 435L;
        this.maxHp = 208;
        this.constitution = 26;
        this.dexterity = 26;
    }
}
