package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ImperialShield extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_imperial_shield_name;
        this.idDescription = R.string.accessory_imperial_shield_description;
        this.idImage = R.drawable.imperial_shield;
        this.price = 564L;
        this.constitution = 16;
        this.dexterity = 5;
        this.defense = 15;
    }
}
