package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class AbherrantFabric extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_aberrant_fabric_name;
        this.idDescription = R.string.item_aberrant_fabric_description;
        this.idImage = R.drawable.abherrant_fabric;
        this.source.add(Integer.valueOf(R.string.raid_name_the_lost_expedition));
        this.price = 20L;
    }
}
