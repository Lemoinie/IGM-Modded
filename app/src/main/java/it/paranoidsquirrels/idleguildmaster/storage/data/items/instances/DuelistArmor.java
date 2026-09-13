package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class DuelistArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_duelist_armor_name;
        this.idDescription = R.string.armor_heavy_duelist_armor_description;
        this.idEffect = R.string.armor_heavy_duelist_armor_effect;
        this.idImage = R.drawable.duelist_armor;
        this.price = 3885L;
        this.maxHp = 75;
        this.constitution = 20;
        this.counterattack = 0.25d;
    }
}
