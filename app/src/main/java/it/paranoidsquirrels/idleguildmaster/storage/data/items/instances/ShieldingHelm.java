package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ShieldingHelm extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_shielding_helm_name;
        this.idDescription = R.string.accessory_shielding_helm_description;
        this.idEffect = R.string.accessory_shielding_helm_effect;
        this.idImage = R.drawable.shielding_helm;
        this.price = 797L;
        this.immunityToStatus = 0.25d;
        this.maxHp = 200;
        this.constitution = 3;
    }
}
