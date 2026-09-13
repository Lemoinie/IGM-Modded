package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatedStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_animated_staff_name;
        this.idDescription = R.string.weapon_staff_animated_staff_description;
        this.idImage = R.drawable.animated_staff;
        this.price = 635L;
        this.intelligence = 40;
    }
}
