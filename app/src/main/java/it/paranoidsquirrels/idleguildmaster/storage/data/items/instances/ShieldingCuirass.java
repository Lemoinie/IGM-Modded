package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ShieldingCuirass extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_shielding_cuirass_name;
        this.idDescription = R.string.armor_heavy_shielding_cuirass_description;
        this.idEffect = R.string.armor_heavy_shielding_cuirass_effect;
        this.idImage = R.drawable.shielding_cuirass;
        this.price = 1224L;
        this.immunityToStatus = 0.3d;
        this.maxHp = 300;
        this.constitution = 15;
    }
}
