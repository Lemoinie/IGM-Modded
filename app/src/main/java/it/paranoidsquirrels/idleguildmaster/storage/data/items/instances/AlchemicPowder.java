package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class AlchemicPowder extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_alchemic_powder_name;
        this.idDescription = R.string.item_alchemic_powder_description;
        this.idImage = R.drawable.alchemic_powder;
        this.source.add(Integer.valueOf(R.string.raid_name_the_cultist_rebels));
        this.price = 100L;
    }
}
