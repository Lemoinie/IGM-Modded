package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class CrystalStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_crystal_staff_name;
        this.idDescription = R.string.weapon_staff_crystal_staff_description;
        this.idEffect = R.string.weapon_staff_crystal_staff_effect;
        this.idImage = R.drawable.crystal_staff;
        this.price = 360L;
        this.intelligence = 26;
        this.immunityToStatus = 0.25d;
    }
}
