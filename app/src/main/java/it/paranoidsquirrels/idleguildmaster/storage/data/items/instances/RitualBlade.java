package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class RitualBlade extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isRanged() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_ritual_blade_name;
        this.idDescription = R.string.weapon_dagger_ritual_blade_description;
        this.idEffect = R.string.weapon_dagger_ritual_blade_effect;
        this.idImage = R.drawable.ritual_blade;
        this.price = 15393L;
        this.dexterity = 12;
        this.intelligence = 16;
        this.healingModifier = 0.6d;
    }
}
