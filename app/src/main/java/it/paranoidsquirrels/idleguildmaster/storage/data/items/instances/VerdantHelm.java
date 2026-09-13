package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class VerdantHelm extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_verdant_helm_name;
        this.idDescription = R.string.accessory_verdant_helm_description;
        this.idImage = R.drawable.verdant_helm;
        this.price = 372L;
        this.maxHp = 160;
    }
}
