package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class AbyssalGoo extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_abyssal_goo_name;
        this.idDescription = R.string.item_abyssal_goo_description;
        this.idImage = R.drawable.abyssal_goo;
        this.price = 1193L;
    }
}
