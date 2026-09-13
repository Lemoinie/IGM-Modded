package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class ArcaneDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isMagic() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_arcane_dagger_name;
        this.idDescription = R.string.weapon_dagger_arcane_dagger_description;
        this.idEffect = R.string.weapon_dagger_arcane_dagger_effect;
        this.idImage = R.drawable.arcane_dagger;
        this.price = 564L;
        this.intelligence = 24;
        this.dexterity = 12;
        this.constitution = 12;
    }
}
