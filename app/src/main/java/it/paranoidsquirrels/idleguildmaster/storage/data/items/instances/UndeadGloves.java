package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class UndeadGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_undead_gloves_name;
        this.idDescription = R.string.accessory_undead_gloves_description;
        this.idImage = R.drawable.undead_gloves;
        this.price = 75L;
        this.constitution = 7;
        this.dexterity = 6;
    }
}
