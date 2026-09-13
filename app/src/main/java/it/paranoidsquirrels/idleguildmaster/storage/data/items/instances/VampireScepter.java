package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class VampireScepter extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_vampire_scepter_name;
        this.idDescription = R.string.weapon_staff_vampire_scepter_description;
        this.idEffect = R.string.weapon_staff_vampire_scepter_effect;
        this.idImage = R.drawable.vampire_scepter;
        this.price = 1026L;
        this.intelligence = 28;
        this.lifesteal = 20;
    }
}
