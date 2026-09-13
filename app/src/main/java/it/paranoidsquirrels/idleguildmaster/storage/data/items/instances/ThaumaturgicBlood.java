package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class ThaumaturgicBlood extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_thaumaturgic_blood_name;
        this.idDescription = R.string.item_thaumaturgic_blood_description;
        this.idImage = R.drawable.thaumaturgic_blood;
        this.price = 89L;
    }
}
