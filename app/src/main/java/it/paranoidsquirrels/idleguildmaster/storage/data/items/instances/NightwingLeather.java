package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class NightwingLeather extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_nightwing_leather_name;
        this.idDescription = R.string.item_nightwing_leather_description;
        this.idImage = R.drawable.nightwing_leather;
        this.price = 9L;
    }
}
