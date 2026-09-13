package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class Mithril extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_mithril_name;
        this.idDescription = R.string.item_mithril_description;
        this.idImage = R.drawable.mithril;
        this.source.add(Integer.valueOf(R.string.dungeon_name_lost_lands));
        this.price = 4L;
    }
}
