package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class UnstableStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public double damageDelta() {
        return 0.8d;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_unstable_staff_name;
        this.idDescription = R.string.weapon_staff_unstable_staff_description;
        this.idEffect = R.string.weapon_staff_unstable_staff_effect;
        this.idImage = R.drawable.unstable_staff;
        this.price = 998L;
        this.intelligence = 40;
    }
}
