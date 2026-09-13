package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class StellarStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_stellar_staff_name;
        this.idDescription = R.string.weapon_staff_stellar_staff_description;
        this.idEffect = R.string.weapon_staff_stellar_staff_effect;
        this.idImage = R.drawable.stellar_staff;
        this.price = 6090L;
        this.onFireBonusDamage = 3;
        this.intelligence = 25;
        this.constitution = 10;
        this.dexterity = 10;
    }
}
