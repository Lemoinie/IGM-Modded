package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class BleakBoots extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_bleak_boots_name;
        this.idDescription = R.string.accessory_bleak_boots_description;
        this.idEffect = R.string.accessory_bleak_boots_effect;
        this.idImage = R.drawable.bleak_boots;
        this.price = 2016L;
        this.flatDodgeChance = 0.2d;
        this.dexterity = 34;
    }
}
