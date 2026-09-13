package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtMane extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_dreamwrought_mane_name;
        this.idDescription = R.string.item_dreamwrought_mane_description;
        this.idImage = R.drawable.dreamwrought_mane;
        this.source.add(Integer.valueOf(R.string.raid_name_sleeping_planet));
        this.price = 5L;
    }
}
