package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses;

import it.paranoidsquirrels.idleguildmaster.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Potion extends Consumable {
    public static final int AGILITY = 10;
    public static final int CONSTITUTION = 0;
    public static final int DARKNESS = 8;
    public static final int DEFENSE = 4;
    public static final int DEXTERITY = 1;
    public static final int HEALTH = 3;
    public static final int IMMUNITY = 9;
    public static final int INTELLIGENCE = 2;
    public static final int MAGIC_DEFENSE = 5;
    public static final int PRECISION = 6;
    public static final int VICIOUSNESS = 7;

    public abstract int getPotionType();

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    public int printType() {
        return R.string.type_potion;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
    public int printConsumeImage() {
        return R.drawable.consume_potion;
    }
}
