package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class BlackIronHelm extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_black_iron_helm_name;
        this.idDescription = R.string.accessory_black_iron_helm_description;
        this.idImage = R.drawable.black_iron_helm;
        this.price = 279L;
        this.maxHp = 100;
    }
}
