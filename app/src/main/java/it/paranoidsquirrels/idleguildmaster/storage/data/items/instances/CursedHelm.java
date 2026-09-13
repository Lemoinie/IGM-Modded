package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class CursedHelm extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_cursed_helm_name;
        this.idDescription = R.string.accessory_cursed_helm_description;
        this.idEffect = R.string.accessory_cursed_helm_effect;
        this.idImage = R.drawable.cursed_helm;
        this.price = 2880L;
        this.maxHp = 105;
        this.retaliationPhysicalDamage = 15;
    }
}
