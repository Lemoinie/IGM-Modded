package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class Quartz extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_quartz_name;
        this.idDescription = R.string.item_quartz_description;
        this.idImage = R.drawable.quartz;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_desert));
        this.source.add(Integer.valueOf(R.string.raid_name_divine_archeology));
        this.price = 5L;
    }
}
