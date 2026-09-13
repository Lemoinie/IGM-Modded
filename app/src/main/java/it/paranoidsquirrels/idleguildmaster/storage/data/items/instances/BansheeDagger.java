package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class BansheeDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_banshee_dagger_name;
        this.idDescription = R.string.weapon_dagger_banshee_dagger_description;
        this.idImage = R.drawable.banshee_dagger;
        this.price = 552L;
        this.constitution = 28;
        this.dexterity = 28;
    }
}
