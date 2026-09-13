package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_dreamwrought_staff_name;
        this.idDescription = R.string.weapon_staff_dreamwrought_staff_description;
        this.idImage = R.drawable.dreamwrought_staff;
        this.price = 893L;
        this.intelligence = 52;
    }
}
