package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class InfiniteDespair extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_infinite_despair_name;
        this.idDescription = R.string.weapon_dagger_infinite_despair_description;
        this.idEffect = R.string.weapon_dagger_infinite_despair_effect;
        this.idImage = R.drawable.infinite_despair;
        this.price = 21000L;
        this.constitution = 60;
        this.dexterity = 60;
        this.decay = 60;
        this.criticalDamage = 1.0d;
    }
}
