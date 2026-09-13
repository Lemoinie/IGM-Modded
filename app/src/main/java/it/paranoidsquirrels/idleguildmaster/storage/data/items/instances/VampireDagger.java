package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class VampireDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_vampire_dagger_name;
        this.idDescription = R.string.weapon_dagger_vampire_dagger_description;
        this.idEffect = R.string.weapon_dagger_vampire_dagger_effect;
        this.idImage = R.drawable.vampire_dagger;
        this.price = 999L;
        this.dexterity = 20;
        this.constitution = 20;
        this.lifesteal = 20;
    }
}
