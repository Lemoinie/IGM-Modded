package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class CelestialHelmet extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_celestial_helmet_name;
        this.idDescription = R.string.accessory_celestial_helmet_description;
        this.idImage = R.drawable.celestial_helmet;
        this.price = 438L;
        this.maxHp = 180;
    }
}
