package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class GreenSlime extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_green_slime_name;
        this.idDescription = R.string.item_green_slime_description;
        this.idImage = R.drawable.green_slime;
        this.source.add(Integer.valueOf(R.string.raid_name_the_slime_pond));
        this.price = 3L;
    }
}
