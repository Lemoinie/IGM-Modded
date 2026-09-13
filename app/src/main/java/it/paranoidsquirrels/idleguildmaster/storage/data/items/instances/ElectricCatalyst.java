package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class ElectricCatalyst extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_electric_catalyst_name;
        this.idDescription = R.string.item_electric_catalyst_description;
        this.idImage = R.drawable.electric_catalyst;
        this.price = 173L;
    }
}
