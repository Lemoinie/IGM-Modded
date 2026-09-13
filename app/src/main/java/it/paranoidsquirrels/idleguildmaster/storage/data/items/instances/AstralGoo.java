package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class AstralGoo extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_astral_goo_name;
        this.idDescription = R.string.item_astral_goo_description;
        this.idImage = R.drawable.astral_goo;
        this.source.add(Integer.valueOf(R.string.raid_name_the_lost_expedition));
        this.price = 4L;
    }
}
