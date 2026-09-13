package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class AncientArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_ancient_armor_name;
        this.idDescription = R.string.armor_heavy_ancient_armor_description;
        this.idImage = R.drawable.ancient_armor;
        this.price = 1092L;
        this.maxHp = 330;
        this.constitution = 11;
    }
}
