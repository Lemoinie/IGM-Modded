package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyHideJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_monkey_hide_jacket_name;
        this.idDescription = R.string.armor_medium_monkey_hide_jacket_description;
        this.idImage = R.drawable.monkey_hide_jacket;
        this.price = 828L;
        this.maxHp = 100;
        this.constitution = 5;
        this.dexterity = 5;
    }
}
