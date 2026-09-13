package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class CrusaderInsigna extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_crusader_insigna_name;
        this.idDescription = R.string.item_crusader_insigna_description;
        this.idImage = R.drawable.crusader_insigna;
        this.source.add(Integer.valueOf(R.string.raid_name_the_cultist_rebels));
        this.price = 52L;
    }
}
