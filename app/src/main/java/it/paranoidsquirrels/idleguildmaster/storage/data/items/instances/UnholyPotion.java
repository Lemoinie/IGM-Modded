package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class UnholyPotion extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_unholy_potion_name;
        this.idDescription = R.string.item_unholy_potion_description;
        this.idImage = R.drawable.unholy_potion;
        this.price = 666L;
    }
}
