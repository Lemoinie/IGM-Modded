package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class BansheeJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_banshee_jacket_name;
        this.idDescription = R.string.armor_medium_banshee_jacket_description;
        this.idImage = R.drawable.banshee_jacket;
        this.price = 666L;
        this.maxHp = 180;
        this.constitution = 9;
        this.dexterity = 9;
    }
}
