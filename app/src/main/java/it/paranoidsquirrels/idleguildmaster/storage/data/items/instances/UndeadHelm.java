package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class UndeadHelm extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_undead_helm_name;
        this.idDescription = R.string.accessory_undead_helm_description;
        this.idImage = R.drawable.undead_helm;
        this.price = 42L;
        this.maxHp = 60;
    }
}
