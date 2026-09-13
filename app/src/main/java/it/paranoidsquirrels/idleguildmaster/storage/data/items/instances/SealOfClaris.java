package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class SealOfClaris extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_seal_of_claris_name;
        this.idDescription = R.string.item_seal_of_claris_description;
        this.idImage = R.drawable.seal_of_claris;
        this.source.add(Integer.valueOf(R.string.raid_name_the_cultist_rebels));
        this.price = 6500L;
    }
}
