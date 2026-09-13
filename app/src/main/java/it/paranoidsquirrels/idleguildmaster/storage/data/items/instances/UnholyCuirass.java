package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class UnholyCuirass extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_unholy_cuirass_name;
        this.idDescription = R.string.armor_heavy_unholy_cuirass_description;
        this.idEffect = R.string.armor_heavy_unholy_cuirass_effect;
        this.idImage = R.drawable.unholy_cuirass;
        this.price = 1607L;
        this.maxHp = 230;
        this.constitution = 8;
        this.retaliationMagicalDamage = 15;
    }
}
