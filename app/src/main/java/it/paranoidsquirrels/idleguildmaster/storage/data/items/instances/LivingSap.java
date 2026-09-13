package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class LivingSap extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_living_sap_name;
        this.idDescription = R.string.item_living_sap_description;
        this.idImage = R.drawable.living_sap;
        this.source.add(Integer.valueOf(R.string.dungeon_name_enchanted_forest));
        this.price = 10L;
    }
}
