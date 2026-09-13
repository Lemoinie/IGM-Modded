package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class BatWing extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_bat_wing_name;
        this.idDescription = R.string.item_bat_wing_description;
        this.idImage = R.drawable.bat_wing;
        this.source.add(Integer.valueOf(R.string.dungeon_name_obsidian_mines));
        this.price = 3L;
    }
}
