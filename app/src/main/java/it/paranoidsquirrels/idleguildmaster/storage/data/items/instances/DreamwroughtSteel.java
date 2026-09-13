package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtSteel extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_dreamwrought_steel_name;
        this.idDescription = R.string.item_dreamwrought_steel_description;
        this.idImage = R.drawable.dreamwrought_steel;
        this.source.add(Integer.valueOf(R.string.raid_name_sleeping_planet));
        this.price = 85L;
    }
}
