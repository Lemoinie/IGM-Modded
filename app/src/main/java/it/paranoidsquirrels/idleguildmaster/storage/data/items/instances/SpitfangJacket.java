package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SpitfangJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_spitfang_jacket_name;
        this.idDescription = R.string.armor_medium_spitfang_jacket_description;
        this.idImage = R.drawable.spitfang_jacket;
        this.price = 288L;
        this.maxHp = 160;
        this.constitution = 8;
        this.dexterity = 8;
    }
}
