package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class BlackIronScepter extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_black_iron_scepter_name;
        this.idDescription = R.string.weapon_staff_black_iron_scepter_description;
        this.idImage = R.drawable.black_iron_scepter;
        this.price = 336L;
        this.intelligence = 20;
    }
}
