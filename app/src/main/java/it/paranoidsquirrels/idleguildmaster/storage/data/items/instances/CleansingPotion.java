package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class CleansingPotion extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_cleansing_potion_name;
        this.idDescription = R.string.item_cleansing_potion_description;
        this.idImage = R.drawable.cleansing_potion;
        this.price = 375L;
    }
}
