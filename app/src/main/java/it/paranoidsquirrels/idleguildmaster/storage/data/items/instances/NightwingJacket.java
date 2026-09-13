package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class NightwingJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_nightwing_jacket_name;
        this.idDescription = R.string.armor_medium_nightwing_jacket_description;
        this.idImage = R.drawable.nightwing_jacket;
        this.price = 567L;
        this.maxHp = 140;
        this.constitution = 7;
        this.dexterity = 7;
    }
}
