package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class OrichalcumDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_orichalcum_dagger_name;
        this.idDescription = R.string.weapon_dagger_orichalcum_dagger_description;
        this.idImage = R.drawable.orichalcum_dagger;
        this.price = 1260L;
        this.constitution = 39;
        this.dexterity = 39;
    }
}
