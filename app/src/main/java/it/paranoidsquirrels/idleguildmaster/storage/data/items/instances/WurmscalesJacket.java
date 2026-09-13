package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class WurmscalesJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_wurmscales_jacket_name;
        this.idDescription = R.string.armor_medium_wurmscales_jacket_description;
        this.idImage = R.drawable.wurmscales_jacket;
        this.price = 45L;
        this.maxHp = 40;
        this.constitution = 2;
        this.dexterity = 2;
    }
}
