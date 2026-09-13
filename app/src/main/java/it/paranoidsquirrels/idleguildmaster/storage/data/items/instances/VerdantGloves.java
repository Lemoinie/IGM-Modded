package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class VerdantGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_verdant_gloves_name;
        this.idDescription = R.string.accessory_verdant_gloves_description;
        this.idImage = R.drawable.verdant_gloves;
        this.price = 498L;
        this.constitution = 20;
        this.dexterity = 16;
    }
}
