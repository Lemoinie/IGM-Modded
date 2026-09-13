package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class VerdantBoots extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_verdant_boots_name;
        this.idDescription = R.string.accessory_verdant_boots_description;
        this.idImage = R.drawable.verdant_boots;
        this.price = 477L;
        this.dexterity = 24;
    }
}
