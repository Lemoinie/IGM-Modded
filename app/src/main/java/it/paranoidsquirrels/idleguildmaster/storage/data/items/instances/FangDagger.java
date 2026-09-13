package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class FangDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_fang_dagger_name;
        this.idDescription = R.string.weapon_dagger_fang_dagger_description;
        this.idImage = R.drawable.fang_dagger;
        this.price = 17L;
        this.constitution = 2;
        this.dexterity = 2;
    }
}
