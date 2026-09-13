package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class InfusionOfWisdom extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_infusion_of_wisdom_name;
        this.idDescription = R.string.item_infusion_of_wisdom_description;
        this.idImage = R.drawable.infusion_of_wisdom;
        this.price = 1965L;
    }
}
