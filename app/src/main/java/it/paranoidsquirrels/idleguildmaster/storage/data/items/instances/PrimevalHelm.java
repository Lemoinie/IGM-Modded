package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class PrimevalHelm extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_primeval_helm_name;
        this.idDescription = R.string.accessory_primeval_helm_description;
        this.idImage = R.drawable.primeval_helm;
        this.price = 1020L;
        this.maxHp = 180;
        this.defense = 12;
    }
}
