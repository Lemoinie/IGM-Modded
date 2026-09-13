package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class FluxLimiter extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_flux_limiter_name;
        this.idDescription = R.string.item_flux_limiter_description;
        this.idImage = R.drawable.flux_limiter;
        this.source.add(Integer.valueOf(R.string.dungeon_name_barren_wastelands));
        this.source.add(Integer.valueOf(R.string.raid_name_celestial_mothership));
        this.price = 38L;
    }
}
