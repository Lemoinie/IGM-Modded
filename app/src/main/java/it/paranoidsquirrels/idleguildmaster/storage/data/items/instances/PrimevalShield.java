package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class PrimevalShield extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_primeval_shield_name;
        this.idDescription = R.string.accessory_primeval_shield_description;
        this.idImage = R.drawable.primeval_shield;
        this.price = 675L;
        this.constitution = 27;
        this.defense = 12;
    }
}
