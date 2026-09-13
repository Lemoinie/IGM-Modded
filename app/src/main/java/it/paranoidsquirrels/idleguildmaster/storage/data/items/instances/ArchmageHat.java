package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ArchmageHat extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_archmage_hat_name;
        this.idDescription = R.string.accessory_archmage_hat_description;
        this.idEffect = R.string.accessory_archmage_hat_effect;
        this.idImage = R.drawable.archmage_hat;
        this.source.add(Integer.valueOf(R.string.dungeon_name_hidden_city_of_larox));
        this.price = 3200L;
        this.intelligence = 35;
        this.criticalDamage = 0.2d;
    }
}
