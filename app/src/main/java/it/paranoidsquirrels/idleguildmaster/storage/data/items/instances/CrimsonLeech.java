package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class CrimsonLeech extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_crimson_leech_name;
        this.idDescription = R.string.weapon_staff_crimson_leech_description;
        this.idEffect = R.string.weapon_staff_crimson_leech_effect;
        this.idImage = R.drawable.crimson_leech;
        this.price = 834L;
        this.intelligence = 16;
        this.constitution = 4;
        this.lifesteal = 20;
    }
}
