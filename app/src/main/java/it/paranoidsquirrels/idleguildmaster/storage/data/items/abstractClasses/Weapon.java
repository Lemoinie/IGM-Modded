package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Weapon extends Equipment {
    public abstract double damageDelta();

    public abstract int damageDescription();

    public abstract int getDamageModifier(int i, int i2, int i3);

    public abstract boolean isMagic();

    public abstract boolean isRanged();
}
