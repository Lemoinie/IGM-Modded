package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class CelestialMercy extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_celestial_mercy_name;
        this.idDescription = R.string.weapon_sword_celestial_mercy_description;
        this.idEffect = R.string.weapon_sword_celestial_mercy_effect;
        this.idImage = R.drawable.celestials_mercy;
        this.price = 1100L;
        this.darknessReduction = 12;
        this.alwaysHits = true;
        this.constitution = 28;
        this.dexterity = 8;
    }
}
