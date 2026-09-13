package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class CrystalDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_crystal_dagger_name;
        this.idDescription = R.string.weapon_dagger_crystal_dagger_description;
        this.idEffect = R.string.weapon_dagger_crystal_dagger_effect;
        this.idImage = R.drawable.crystal_dagger;
        this.price = 378L;
        this.dexterity = 17;
        this.constitution = 17;
        this.criticalDamage = 0.3d;
    }
}
