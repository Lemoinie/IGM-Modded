package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class BleakGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_bleak_gloves_name;
        this.idDescription = R.string.accessory_bleak_gloves_description;
        this.idEffect = R.string.accessory_bleak_gloves_effect;
        this.idImage = R.drawable.bleak_gloves;
        this.price = 1584L;
        this.flatDodgeChance = 0.2d;
        this.constitution = 18;
        this.dexterity = 19;
    }
}
