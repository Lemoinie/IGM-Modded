package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class GemOfProtection extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_gem_of_protection_name;
        this.idDescription = R.string.accessory_gem_of_protection_description;
        this.idImage = R.drawable.gem_of_protection;
        this.price = 60L;
    }
}
