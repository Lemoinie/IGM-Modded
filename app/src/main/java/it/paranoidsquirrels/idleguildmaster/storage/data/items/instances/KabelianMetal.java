package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class KabelianMetal extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_kabelian_metal_name;
        this.idDescription = R.string.item_kabelian_metal_description;
        this.idImage = R.drawable.kabelian_metal;
        this.source.add(Integer.valueOf(R.string.raid_name_the_cultist_rebels));
        this.price = 80L;
    }
}
