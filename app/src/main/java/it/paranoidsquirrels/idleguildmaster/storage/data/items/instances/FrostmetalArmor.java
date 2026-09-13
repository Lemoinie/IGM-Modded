package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class FrostmetalArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_frostmetal_armor_name;
        this.idDescription = R.string.armor_heavy_frostmetal_armor_description;
        this.idEffect = R.string.armor_heavy_frostmetal_armor_effect;
        this.idImage = R.drawable.frostmetal_armor;
        this.price = 504L;
        this.maxHp = 180;
        this.constitution = 5;
        this.regeneration = 6;
    }
}
