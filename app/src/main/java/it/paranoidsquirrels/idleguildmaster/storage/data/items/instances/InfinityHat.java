package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class InfinityHat extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_infinity_hat_name;
        this.idDescription = R.string.accessory_infinity_hat_description;
        this.idEffect = R.string.accessory_infinity_hat_effect;
        this.idImage = R.drawable.infinity_hat;
        this.source.add(Integer.valueOf(R.string.raid_name_sleeping_planet));
        this.price = 15000L;
        this.maxHp = 60;
        this.intelligence = 35;
        this.criticalDamage = 0.25d;
    }
}
