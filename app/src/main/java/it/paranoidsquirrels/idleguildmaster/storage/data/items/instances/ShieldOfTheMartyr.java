package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ShieldOfTheMartyr extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_shield_of_the_martyr_name;
        this.idDescription = R.string.accessory_shield_of_the_martyr_description;
        this.idEffect = R.string.accessory_shield_of_the_martyr_effect;
        this.idImage = R.drawable.shield_of_the_martyr;
        this.price = 26500L;
        this.constitution = 22;
        this.defense = 8;
        this.magicDefense = 8;
        this.threat = 2;
    }
}
