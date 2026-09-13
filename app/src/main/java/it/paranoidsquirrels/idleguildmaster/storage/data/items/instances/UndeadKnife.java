package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class UndeadKnife extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_undead_knife_name;
        this.idDescription = R.string.weapon_dagger_undead_knife_description;
        this.idEffect = R.string.weapon_dagger_undead_knife_effect;
        this.idImage = R.drawable.undead_knife;
        this.price = 54L;
        this.constitution = 7;
        this.dexterity = 7;
        this.criticalChance = 0.06d;
    }
}
