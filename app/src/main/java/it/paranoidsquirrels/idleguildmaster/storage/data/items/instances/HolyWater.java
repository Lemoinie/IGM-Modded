package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class HolyWater extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_holy_water_name;
        this.idDescription = R.string.item_holy_water_description;
        this.idImage = R.drawable.holy_water;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_golden_city));
        this.price = 70L;
    }
}
