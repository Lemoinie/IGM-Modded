package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class MitreHat extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_mitre_hat_name;
        this.idDescription = R.string.accessory_mitre_hat_description;
        this.idEffect = R.string.accessory_mitre_hat_effect;
        this.idImage = R.drawable.mitre_hat;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_golden_city));
        this.price = 450L;
        this.maxHp = 60;
        this.intelligence = 9;
        this.healingModifier = 0.2d;
    }
}
