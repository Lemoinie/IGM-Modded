package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class CursedSilver extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_cursed_silver_name;
        this.idDescription = R.string.item_cursed_silver_description;
        this.idImage = R.drawable.cursed_silver;
        this.source.add(Integer.valueOf(R.string.raid_name_ancient_grave_digging));
        this.price = 160L;
    }
}
