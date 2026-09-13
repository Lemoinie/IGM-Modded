package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses;

import it.paranoidsquirrels.idleguildmaster.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Dagger extends Weapon {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public double damageDelta() {
        return 0.25d;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public int getDamageModifier(int i, int i2, int i3) {
        return i + i3;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isMagic() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isRanged() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    public int printType() {
        return R.string.type_dagger;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public int damageDescription() {
        return R.string.help_attack_daggers;
    }
}
