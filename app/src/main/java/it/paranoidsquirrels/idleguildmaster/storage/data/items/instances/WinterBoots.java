package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class WinterBoots extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_winter_boots_name;
        this.idDescription = R.string.accessory_winter_boots_description;
        this.idEffect = R.string.accessory_winter_boots_effect;
        this.idImage = R.drawable.winter_boots;
        this.price = 204L;
        this.dexterity = 18;
        this.regeneration = 4;
    }
}
