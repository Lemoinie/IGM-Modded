package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class StaffOfTheArchmage extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public double damageDelta() {
        return 0.11935110081112399d;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_staff_of_the_archmage_name;
        this.idDescription = R.string.weapon_staff_staff_of_the_archmage_description;
        this.idEffect = R.string.weapon_staff_staff_of_the_archmage_effect;
        this.idImage = R.drawable.staff_of_the_archmage;
        this.price = 1707L;
        this.intelligence = 40;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public int getDamageModifier(int i, int i2, int i3) {
        return (int) (((double) super.getDamageModifier(i, i2, i3)) * 1.07875d);
    }
}
