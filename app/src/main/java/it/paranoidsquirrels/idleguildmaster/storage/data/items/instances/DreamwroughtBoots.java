package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtBoots extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_dreamwrought_boots_name;
        this.idDescription = R.string.accessory_dreamwrought_boots_description;
        this.idImage = R.drawable.dreamwrought_boots;
        this.price = 789L;
        this.dexterity = 42;
    }
}
