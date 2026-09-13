package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class VoidCrusher extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_void_crusher_name;
        this.idDescription = R.string.weapon_sword_void_crusher_description;
        this.idEffect = R.string.weapon_sword_void_crusher_effect;
        this.idImage = R.drawable.void_crusher;
        this.price = 21750L;
        this.constitution = 100;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public int getDamageModifier(int i, int i2, int i3) {
        return i >= 275 ? i : i / 2;
    }
}
