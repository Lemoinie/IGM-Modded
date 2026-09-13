package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class OrbOfEctoplasm extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_orb_of_ectoplasm_name;
        this.idDescription = R.string.item_orb_of_ectoplasm_description;
        this.idImage = R.drawable.orb_of_ectoplasm;
        this.source.add(Integer.valueOf(R.string.dungeon_name_eternal_battlefield));
        this.price = 50L;
    }
}
