package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class Feather extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_feather_name;
        this.idDescription = R.string.item_feather_description;
        this.idImage = R.drawable.feather;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_desert));
        this.price = 2L;
    }
}
