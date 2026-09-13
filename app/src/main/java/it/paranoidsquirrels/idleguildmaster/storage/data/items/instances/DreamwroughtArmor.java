package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_dreamwrought_armor_name;
        this.idDescription = R.string.armor_heavy_dreamwrought_armor_description;
        this.idImage = R.drawable.dreamwrought_armor;
        this.price = 1245L;
        this.maxHp = 338;
        this.constitution = 26;
    }
}
