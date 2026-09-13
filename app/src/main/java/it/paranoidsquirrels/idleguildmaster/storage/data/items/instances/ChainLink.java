package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class ChainLink extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_chain_link_name;
        this.idDescription = R.string.item_chain_link_description;
        this.idImage = R.drawable.chain_link;
        this.source.add(Integer.valueOf(R.string.dungeon_name_barren_wastelands));
        this.price = 9L;
    }
}
