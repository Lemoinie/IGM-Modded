package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class EnchantedStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_enchanted_staff_name;
        this.idDescription = R.string.weapon_staff_enchanted_staff_description;
        this.idImage = R.drawable.enchanted_staff;
        this.price = 45L;
        this.intelligence = 4;
    }
}
