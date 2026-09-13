package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtHide extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_dreamwrought_hide_name;
        this.idDescription = R.string.item_dreamwrought_hide_description;
        this.idImage = R.drawable.dreamwrought_hide;
        this.source.add(Integer.valueOf(R.string.raid_name_sleeping_planet));
        this.price = 25L;
    }
}
