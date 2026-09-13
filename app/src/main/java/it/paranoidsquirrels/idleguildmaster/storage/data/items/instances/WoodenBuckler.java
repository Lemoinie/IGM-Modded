package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class WoodenBuckler extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_wooden_buckler_name;
        this.idDescription = R.string.accessory_wooden_buckler_description;
        this.idImage = R.drawable.wooden_buckler;
        this.price = 9L;
        this.constitution = 3;
    }
}
