package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class ObsidianScepter extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_obsidian_scepter_name;
        this.idDescription = R.string.weapon_staff_obsidian_scepter_description;
        this.idImage = R.drawable.obsidian_scepter;
        this.price = 324L;
        this.intelligence = 28;
    }
}
