package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class MutualDespair extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_mutual_despair_name;
        this.idDescription = R.string.weapon_dagger_mutual_despair_description;
        this.idEffect = R.string.weapon_dagger_mutual_despair_effect;
        this.idImage = R.drawable.mutual_despair;
        this.price = 10500L;
        this.constitution = 30;
        this.dexterity = 30;
        this.decay = 20;
        this.criticalDamage = 0.65d;
    }
}
