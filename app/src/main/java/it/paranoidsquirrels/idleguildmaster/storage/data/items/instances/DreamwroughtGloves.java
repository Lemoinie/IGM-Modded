package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_dreamwrought_gloves_name;
        this.idDescription = R.string.accessory_dreamwrought_gloves_description;
        this.idImage = R.drawable.dreamwrought_gloves;
        this.price = 884L;
        this.constitution = 34;
        this.dexterity = 28;
    }
}
