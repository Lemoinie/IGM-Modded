package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class WurmscalesGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_wurmscales_gloves_name;
        this.idDescription = R.string.accessory_wurmscales_gloves_description;
        this.idImage = R.drawable.wurmscales_gloves;
        this.price = 36L;
        this.constitution = 4;
        this.dexterity = 4;
    }
}
