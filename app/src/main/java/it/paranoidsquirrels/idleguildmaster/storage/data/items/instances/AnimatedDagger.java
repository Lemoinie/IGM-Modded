package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatedDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_animated_dagger_name;
        this.idDescription = R.string.weapon_dagger_animated_dagger_description;
        this.idImage = R.drawable.animated_dagger;
        this.price = 608L;
        this.constitution = 30;
        this.dexterity = 30;
    }
}
