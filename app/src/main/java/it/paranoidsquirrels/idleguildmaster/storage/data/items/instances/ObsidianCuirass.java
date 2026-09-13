package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ObsidianCuirass extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_obsidian_cuirass_name;
        this.idDescription = R.string.armor_heavy_obsidian_cuirass_description;
        this.idImage = R.drawable.obsidian_cuirass;
        this.price = 405L;
        this.maxHp = 210;
        this.constitution = 7;
    }
}
