package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class WinterGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_winter_gloves_name;
        this.idDescription = R.string.accessory_winter_gloves_description;
        this.idEffect = R.string.accessory_winter_gloves_effect;
        this.idImage = R.drawable.winter_gloves;
        this.price = 264L;
        this.constitution = 16;
        this.dexterity = 13;
        this.regeneration = 4;
    }
}
