package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class SpectralCloth extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_spectral_cloth_name;
        this.idDescription = R.string.item_spectral_cloth_description;
        this.idImage = R.drawable.spectral_cloth;
        this.source.add(Integer.valueOf(R.string.dungeon_name_eternal_battlefield));
        this.price = 6L;
    }
}
