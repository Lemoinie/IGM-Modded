package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class ShahuriBowFrame extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_shahuri_bow_frame_name;
        this.idDescription = R.string.item_shahuri_bow_frame_description;
        this.idImage = R.drawable.shahuri_bow_frame;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_desert));
        this.source.add(Integer.valueOf(R.string.raid_name_divine_archeology));
        this.price = 55L;
    }
}
