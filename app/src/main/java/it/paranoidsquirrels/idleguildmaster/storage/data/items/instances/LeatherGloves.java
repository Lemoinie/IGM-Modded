package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class LeatherGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_leather_gloves_name;
        this.idDescription = R.string.accessory_leather_gloves_description;
        this.idImage = R.drawable.leather_gloves;
        this.price = 41L;
        this.dexterity = 2;
        this.constitution = 2;
    }
}
