package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class ImperialStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_imperial_staff_name;
        this.idDescription = R.string.weapon_staff_imperial_staff_description;
        this.idImage = R.drawable.imperial_staff;
        this.price = 564L;
        this.intelligence = 26;
        this.constitution = 8;
        this.dexterity = 8;
    }
}
