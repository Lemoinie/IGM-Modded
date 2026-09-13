package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class UndeadJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_undead_jacket_name;
        this.idDescription = R.string.armor_medium_undead_jacket_description;
        this.idImage = R.drawable.undead_jacket;
        this.price = 72L;
        this.maxHp = 60;
        this.constitution = 3;
        this.dexterity = 3;
    }
}
