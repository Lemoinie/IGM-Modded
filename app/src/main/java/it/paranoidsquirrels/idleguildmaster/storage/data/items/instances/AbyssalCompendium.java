package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class AbyssalCompendium extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_abyssal_compendium_name;
        this.idDescription = R.string.accessory_abyssal_compendium_description;
        this.idImage = R.drawable.abyssal_compendium;
        this.price = 375L;
        this.intelligence = 15;
    }
}
