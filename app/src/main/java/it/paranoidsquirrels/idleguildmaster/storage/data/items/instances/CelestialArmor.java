package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class CelestialArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_celestial_armor_name;
        this.idDescription = R.string.armor_heavy_celestial_armor_description;
        this.idImage = R.drawable.celestial_armor;
        this.price = 653L;
        this.maxHp = 270;
        this.constitution = 9;
    }
}
