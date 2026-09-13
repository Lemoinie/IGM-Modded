package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class FlakeOfInfinity extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_flake_of_infinity_name;
        this.idDescription = R.string.item_flake_of_infinity_description;
        this.idImage = R.drawable.flake_of_infinity;
        this.source.add(Integer.valueOf(R.string.raid_name_sleeping_planet));
        this.price = 250L;
    }
}
