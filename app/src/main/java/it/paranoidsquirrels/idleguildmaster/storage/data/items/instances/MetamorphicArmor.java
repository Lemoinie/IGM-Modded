package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class MetamorphicArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_metamorphic_armor_name;
        this.idDescription = R.string.armor_heavy_metamorphic_armor_description;
        this.idEffect = R.string.armor_heavy_metamorphic_armor_effect;
        this.idImage = R.drawable.metamorphic_armor;
        this.price = 1188L;
        this.maxHp = 140;
        this.constitution = 5;
        this.retaliationPhysicalDamage = 10;
    }
}
