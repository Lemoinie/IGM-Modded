package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class CopperHelmet extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_copper_helmet_name;
        this.idDescription = R.string.accessory_copper_helmet_description;
        this.idImage = R.drawable.copper_helmet;
        this.price = 24L;
        this.maxHp = 20;
    }
}
