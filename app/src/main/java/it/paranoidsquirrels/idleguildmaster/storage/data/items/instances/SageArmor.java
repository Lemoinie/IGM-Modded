package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SageArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_sage_armor_name;
        this.idDescription = R.string.armor_heavy_sage_armor_description;
        this.idEffect = R.string.armor_heavy_sage_armor_effect;
        this.idImage = R.drawable.sage_armor;
        this.price = 3915L;
        this.maxHp = 210;
        this.constitution = 7;
        this.bonusExperience = 60;
    }
}
