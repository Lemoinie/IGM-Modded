package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class GiftOfLight extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_gift_of_light_name;
        this.idDescription = R.string.item_gift_of_light_description;
        this.idImage = R.drawable.gift_of_light;
        this.source.add(Integer.valueOf(R.string.raid_name_the_tower));
        this.price = 1250L;
    }
}
