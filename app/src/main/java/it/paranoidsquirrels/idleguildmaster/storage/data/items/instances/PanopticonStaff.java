package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class PanopticonStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_panopticon_staff_name;
        this.idDescription = R.string.weapon_staff_panopticon_staff_description;
        this.idEffect = R.string.weapon_staff_panopticon_staff_effect;
        this.idImage = R.drawable.panopticon_staff;
        this.price = 642L;
        this.intelligence = 32;
        this.darknessReduction = 16;
    }
}
