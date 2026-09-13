package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class FlyingReaper extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isRanged() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_flying_reaper_name;
        this.idDescription = R.string.weapon_dagger_flying_reaper_description;
        this.idEffect = R.string.weapon_dagger_flying_reaper_effect;
        this.idImage = R.drawable.flying_reaper;
        this.price = 2400L;
        this.dexterity = 20;
        this.constitution = 15;
    }
}
