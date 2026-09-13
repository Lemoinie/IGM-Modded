package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class WhiteHair extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_white_hair_name;
        this.idDescription = R.string.item_white_hair_description;
        this.idImage = R.drawable.white_hair;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_southern_grove));
        this.price = 90L;
    }
}
