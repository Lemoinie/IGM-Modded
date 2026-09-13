package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class FullmoonDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_fullmoon_dagger_name;
        this.idDescription = R.string.weapon_dagger_fullmoon_dagger_description;
        this.idEffect = R.string.weapon_dagger_fullmoon_dagger_effect;
        this.idImage = R.drawable.fullmoon_dagger;
        this.price = 45L;
        this.constitution = 5;
        this.dexterity = 5;
        this.lifesteal = 15;
    }
}
