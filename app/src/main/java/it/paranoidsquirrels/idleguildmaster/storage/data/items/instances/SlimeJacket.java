package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SlimeJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_slime_jacket_name;
        this.idDescription = R.string.armor_medium_slime_jacket_description;
        this.idImage = R.drawable.slime_jacket;
        this.price = 630L;
        this.maxHp = 130;
        this.defense = 5;
    }
}
