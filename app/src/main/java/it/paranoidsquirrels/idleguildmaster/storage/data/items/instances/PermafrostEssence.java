package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class PermafrostEssence extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_permafrost_essence_name;
        this.idDescription = R.string.item_permafrost_essence_description;
        this.idImage = R.drawable.permafrost_essence;
        this.price = 1008L;
    }
}
