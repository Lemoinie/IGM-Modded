package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class VeilShatterer extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_veil_shatterer_name;
        this.idDescription = R.string.item_veil_shatterer_description;
        this.idImage = R.drawable.veil_shatterer;
        this.price = 90L;
    }
}
