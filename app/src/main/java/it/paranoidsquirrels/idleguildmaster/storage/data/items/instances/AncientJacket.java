package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class AncientJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_ancient_jacket_name;
        this.idDescription = R.string.armor_medium_ancient_jacket_description;
        this.idImage = R.drawable.ancient_jacket;
        this.price = 600L;
        this.maxHp = 220;
        this.constitution = 11;
        this.dexterity = 11;
    }
}
