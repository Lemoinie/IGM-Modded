package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class GoldenArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_golden_armor_name;
        this.idDescription = R.string.armor_heavy_golden_armor_description;
        this.idImage = R.drawable.golden_armor;
        this.price = 552L;
        this.maxHp = Logger.BARD_SHIELD;
        this.constitution = 4;
    }
}
