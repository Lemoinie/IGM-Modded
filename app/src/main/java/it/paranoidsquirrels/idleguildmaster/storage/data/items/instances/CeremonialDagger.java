package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class CeremonialDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isRanged() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_ceremonial_dagger_name;
        this.idDescription = R.string.weapon_dagger_ceremonial_dagger_description;
        this.idEffect = R.string.weapon_dagger_ceremonial_dagger_effect;
        this.idImage = R.drawable.ceremonial_dagger;
        this.price = 864L;
        this.dexterity = 8;
        this.intelligence = 8;
        this.healingModifier = 0.4d;
    }
}
