package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class BlackHide extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_black_hide_name;
        this.idDescription = R.string.item_black_hide_description;
        this.idImage = R.drawable.black_hide;
        this.source.add(Integer.valueOf(R.string.raid_name_the_lost_expedition));
        this.price = 16L;
    }
}
