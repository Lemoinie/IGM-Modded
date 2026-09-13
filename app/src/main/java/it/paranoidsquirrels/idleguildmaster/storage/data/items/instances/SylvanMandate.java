package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class SylvanMandate extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isMagic() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_sylvan_mandate_name;
        this.idDescription = R.string.weapon_dagger_sylvan_mandate_description;
        this.idEffect = R.string.weapon_dagger_sylvan_mandate_effect;
        this.idImage = R.drawable.sylvan_mandate;
        this.price = 12006L;
        this.intelligence = 50;
        this.dexterity = 30;
        this.constitution = 30;
    }
}
