package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class BottledSandSpirit extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_bottled_sand_spirit_name;
        this.idDescription = R.string.item_bottled_sand_spirit_description;
        this.idImage = R.drawable.bottled_sand_spirit;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_desert));
        this.price = 110L;
    }
}
