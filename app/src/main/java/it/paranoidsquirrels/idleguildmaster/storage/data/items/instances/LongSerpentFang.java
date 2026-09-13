package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class LongSerpentFang extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_long_serpent_fang_name;
        this.idDescription = R.string.item_long_serpent_fang_description;
        this.idImage = R.drawable.long_serpent_fang;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_southern_grove));
        this.price = 36L;
    }
}
