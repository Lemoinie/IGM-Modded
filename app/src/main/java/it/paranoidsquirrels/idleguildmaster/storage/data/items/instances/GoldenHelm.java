package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class GoldenHelm extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_golden_helm_name;
        this.idDescription = R.string.accessory_golden_helm_description;
        this.idImage = R.drawable.golden_helm;
        this.price = 363L;
        this.maxHp = 80;
    }
}
