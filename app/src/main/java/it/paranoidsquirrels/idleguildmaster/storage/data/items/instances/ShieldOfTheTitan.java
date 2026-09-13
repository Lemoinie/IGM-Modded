package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ShieldOfTheTitan extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_shield_of_the_titan_name;
        this.idDescription = R.string.accessory_shield_of_the_titan_description;
        this.idEffect = R.string.accessory_shield_of_the_titan_effect;
        this.idImage = R.drawable.shield_of_the_titan;
        this.price = 2700L;
        this.constitution = 16;
        this.defense = 5;
        this.magicDefense = 5;
        this.threat = 1;
    }
}
