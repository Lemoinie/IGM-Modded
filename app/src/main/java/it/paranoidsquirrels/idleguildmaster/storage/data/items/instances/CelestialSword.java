package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class CelestialSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_celestial_sword_name;
        this.idDescription = R.string.weapon_sword_celestial_sword_description;
        this.idImage = R.drawable.celestial_sword;
        this.price = 581L;
        this.constitution = 28;
        this.dexterity = 8;
    }
}
