package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SwarmkeeperArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_swarmkeeper_armor_name;
        this.idDescription = R.string.armor_heavy_swarmkeeper_armor_description;
        this.idEffect = R.string.armor_heavy_swarmkeeper_armor_effect;
        this.idImage = R.drawable.swarmkeeper_armor;
        this.price = 3368L;
        this.retaliationMagicalDamage = 100;
        this.maxHp = 390;
        this.constitution = 13;
    }
}
