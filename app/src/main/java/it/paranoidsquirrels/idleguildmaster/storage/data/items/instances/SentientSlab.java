package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class SentientSlab extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_sentient_slab_name;
        this.idDescription = R.string.item_sentient_slab_description;
        this.idImage = R.drawable.sentient_slab;
        this.source.add(Integer.valueOf(R.string.raid_name_the_cultist_rebels));
        this.price = 150L;
    }
}
