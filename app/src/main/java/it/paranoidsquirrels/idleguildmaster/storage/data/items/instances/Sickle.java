package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class Sickle extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_sickle_name;
        this.idDescription = R.string.weapon_dagger_sickle_description;
        this.idImage = R.drawable.sickle;
        this.price = 0L;
        this.dexterity = 1;
        this.constitution = 1;
    }
}
