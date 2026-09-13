package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class MysteriousCog extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_mysterious_cog_name;
        this.idDescription = R.string.item_mysterious_cog_description;
        this.idImage = R.drawable.mysterious_cog;
        this.source.add(Integer.valueOf(R.string.raid_name_the_tower));
        this.price = 2000L;
    }
}
