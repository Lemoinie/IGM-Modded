package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class FrostmetalDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_frostmetal_dagger_name;
        this.idDescription = R.string.weapon_dagger_frostmetal_dagger_description;
        this.idImage = R.drawable.frostmetal_dagger;
        this.price = 450L;
        this.dexterity = 17;
        this.constitution = 17;
    }
}
