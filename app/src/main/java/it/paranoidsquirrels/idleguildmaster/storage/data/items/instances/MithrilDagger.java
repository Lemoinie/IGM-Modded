package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class MithrilDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_mithril_dagger_name;
        this.idDescription = R.string.weapon_dagger_mithril_dagger_description;
        this.idImage = R.drawable.mithril_dagger;
        this.price = 996L;
        this.constitution = 33;
        this.dexterity = 33;
    }
}
