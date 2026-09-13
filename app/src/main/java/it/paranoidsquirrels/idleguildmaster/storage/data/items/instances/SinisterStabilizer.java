package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class SinisterStabilizer extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_sinister_stabilizer_name;
        this.idDescription = R.string.item_sinister_stabilizer_description;
        this.idImage = R.drawable.sinister_stabilizer;
        this.price = 885L;
    }
}
