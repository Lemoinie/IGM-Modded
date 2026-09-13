package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class GhostwoodBoard extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_ghostwoood_board_name;
        this.idDescription = R.string.item_ghostwoood_board_description;
        this.idImage = R.drawable.ghostwood_board;
        this.source.add(Integer.valueOf(R.string.dungeon_name_blackwater_port));
        this.price = 9L;
    }
}
