package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class RadiatingNucleus extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_radiating_nucleus_name;
        this.idDescription = R.string.item_radiating_nucleus_description;
        this.idImage = R.drawable.radiating_nucleus;
        this.source.add(Integer.valueOf(R.string.dungeon_name_hidden_city_of_larox));
        this.price = 10L;
    }
}
