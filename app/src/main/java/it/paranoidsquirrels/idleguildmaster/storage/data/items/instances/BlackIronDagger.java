package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class BlackIronDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_black_iron_dagger_name;
        this.idDescription = R.string.weapon_dagger_black_iron_dagger_description;
        this.idImage = R.drawable.black_iron_dagger;
        this.price = 342L;
        this.dexterity = 14;
        this.constitution = 14;
    }
}
