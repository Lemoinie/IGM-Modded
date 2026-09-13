package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class ShadowDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_shadow_dagger_name;
        this.idDescription = R.string.weapon_dagger_shadow_dagger_description;
        this.idEffect = R.string.weapon_dagger_shadow_dagger_effect;
        this.idImage = R.drawable.shadow_dagger;
        this.price = 1346L;
        this.dexterity = 20;
        this.constitution = 20;
        this.darknessDamageAmplification = 0.005d;
    }
}
