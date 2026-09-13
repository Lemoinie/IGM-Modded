package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class PrehistoricMixture extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_prehistoric_mixture_name;
        this.idDescription = R.string.item_prehistoric_mixture_description;
        this.idImage = R.drawable.prehistoric_mixture;
        this.source.add(Integer.valueOf(R.string.dungeon_name_lost_lands));
        this.price = 315L;
    }
}
