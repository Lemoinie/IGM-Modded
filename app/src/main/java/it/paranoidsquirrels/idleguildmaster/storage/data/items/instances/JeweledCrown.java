package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class JeweledCrown extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_jeweled_crown_name;
        this.idDescription = R.string.accessory_jeweled_crown_description;
        this.idEffect = R.string.accessory_jeweled_crown_effect;
        this.idImage = R.drawable.jeweled_crown;
        this.price = 2790L;
        this.initiative = true;
        this.alwaysHits = true;
        this.defense = 10;
        this.magicDefense = 10;
    }
}
