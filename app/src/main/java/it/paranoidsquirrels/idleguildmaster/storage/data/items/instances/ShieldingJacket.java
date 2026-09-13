package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ShieldingJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_shielding_jacket_name;
        this.idDescription = R.string.armor_medium_shielding_jacket_description;
        this.idEffect = R.string.armor_heavy_shielding_cuirass_effect;
        this.idImage = R.drawable.shielding_jacket;
        this.price = 1202L;
        this.immunityToStatus = 0.3d;
        this.maxHp = 200;
        this.constitution = 15;
        this.dexterity = 10;
    }
}
