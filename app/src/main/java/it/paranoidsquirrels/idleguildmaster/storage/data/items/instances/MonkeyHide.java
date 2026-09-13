package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class MonkeyHide extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_monkey_hide_name;
        this.idDescription = R.string.item_monkey_hide_description;
        this.idImage = R.drawable.monkey_hide;
        this.source.add(Integer.valueOf(R.string.dungeon_name_blackwater_port));
        this.price = 3L;
    }
}
