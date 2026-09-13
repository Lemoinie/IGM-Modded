package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class CorruptedStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_corrupted_staff_name;
        this.idDescription = R.string.weapon_staff_corrupted_staff_description;
        this.idImage = R.drawable.corrupted_staff;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_golden_city));
        this.source.add(Integer.valueOf(R.string.raid_name_imperial_rescue));
        this.price = 1L;
        this.intelligence = 1;
    }
}
