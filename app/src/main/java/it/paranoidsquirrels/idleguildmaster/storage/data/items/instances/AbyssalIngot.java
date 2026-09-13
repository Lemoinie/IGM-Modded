package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class AbyssalIngot extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_abyssal_ingot_name;
        this.idDescription = R.string.item_abyssal_ingot_description;
        this.idImage = R.drawable.abyssal_ingot;
        this.price = 1811L;
    }
}
