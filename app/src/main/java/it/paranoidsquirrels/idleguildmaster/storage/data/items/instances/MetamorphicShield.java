package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class MetamorphicShield extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_metamorphic_shield_name;
        this.idDescription = R.string.accessory_metamorphic_shield_description;
        this.idEffect = R.string.accessory_metamorphic_shield_effect;
        this.idImage = R.drawable.metamorphic_shield;
        this.price = 143L;
        this.constitution = 8;
        this.retaliationPhysicalDamage = 6;
    }
}
