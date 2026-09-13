package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class WickedSeal extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_wicked_seal_name;
        this.idDescription = R.string.item_wicked_seal_description;
        this.idImage = R.drawable.wicked_seal;
        this.source.add(Integer.valueOf(R.string.dungeon_name_hidden_city_of_larox));
        this.price = 250L;
    }
}
