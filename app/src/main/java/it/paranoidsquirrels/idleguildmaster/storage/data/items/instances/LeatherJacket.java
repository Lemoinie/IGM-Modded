package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class LeatherJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_leather_jacket_name;
        this.idDescription = R.string.armor_medium_leather_jacket_description;
        this.idImage = R.drawable.leather_jacket;
        this.price = 45L;
        this.maxHp = 20;
        this.constitution = 1;
        this.dexterity = 1;
    }
}
