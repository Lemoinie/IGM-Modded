package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class SunStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_sun_staff_name;
        this.idDescription = R.string.weapon_staff_sun_staff_description;
        this.idEffect = R.string.weapon_staff_sun_staff_effect;
        this.idImage = R.drawable.sun_staff;
        this.price = 1560L;
        this.onFireBonusDamage = 2;
        this.intelligence = 13;
        this.constitution = 2;
        this.dexterity = 2;
    }
}
