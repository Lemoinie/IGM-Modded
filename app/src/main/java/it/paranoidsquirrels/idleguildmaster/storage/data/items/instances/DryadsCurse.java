package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class DryadsCurse extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isMagic() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_dryads_curse_name;
        this.idDescription = R.string.weapon_dagger_dryads_curse_description;
        this.idEffect = R.string.weapon_dagger_dryads_curse_effect;
        this.idImage = R.drawable.dryads_curse;
        this.price = 504L;
        this.intelligence = 30;
        this.dexterity = 18;
        this.constitution = 18;
    }
}
