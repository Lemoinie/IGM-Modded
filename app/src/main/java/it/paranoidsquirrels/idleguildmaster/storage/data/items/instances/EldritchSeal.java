package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class EldritchSeal extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_eldritch_seal_name;
        this.idDescription = R.string.item_eldritch_seal_description;
        this.idImage = R.drawable.eldritch_seal;
        this.price = 893L;
    }
}
