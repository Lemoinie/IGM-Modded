package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class ScarletStrand extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_scarlet_strand_name;
        this.idDescription = R.string.item_scarlet_strand_description;
        this.idImage = R.drawable.scarlet_strand;
        this.price = 20000L;
    }
}
