package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class GhastlyCuirass extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_ghastly_cuirass_name;
        this.idDescription = R.string.armor_heavy_ghastly_cuirass_description;
        this.idEffect = R.string.armor_heavy_ghastly_cuirass_effect;
        this.idImage = R.drawable.ghastly_cuirass;
        this.price = 1686L;
        this.maxHp = 90;
        this.constitution = 6;
        this.magicDefense = 10;
        this.threat = 1;
    }
}
