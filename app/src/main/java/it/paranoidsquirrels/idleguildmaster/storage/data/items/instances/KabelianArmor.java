package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class KabelianArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_kabelian_armor_name;
        this.idDescription = R.string.armor_heavy_kabelian_armor_description;
        this.idEffect = R.string.armor_heavy_kabelian_armor_effect;
        this.idImage = R.drawable.kabelian_armor;
        this.price = 3276L;
        this.maxHp = 105;
        this.constitution = 20;
        this.darknessReduction = 20;
    }
}
