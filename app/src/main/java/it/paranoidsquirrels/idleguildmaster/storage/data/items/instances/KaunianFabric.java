package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class KaunianFabric extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_kaunian_fabric_name;
        this.idDescription = R.string.item_kaunian_fabric_description;
        this.idImage = R.drawable.kaunian_fabric;
        this.source.add(Integer.valueOf(R.string.raid_name_kaunis));
        this.price = 25L;
    }
}
