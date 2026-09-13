package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class CursedScepter extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_cursed_scepter_name;
        this.idDescription = R.string.weapon_staff_cursed_scepter_description;
        this.idEffect = R.string.weapon_staff_cursed_scepter_effect;
        this.idImage = R.drawable.cursed_scepter;
        this.price = 8468L;
        this.intelligence = 55;
    }
}
