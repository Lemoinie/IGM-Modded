package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class WurmscalesBoots extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_wurmscales_boots_name;
        this.idDescription = R.string.accessory_wurmscales_boots_description;
        this.idImage = R.drawable.wurmscales_boots;
        this.price = 30L;
        this.dexterity = 6;
    }
}
