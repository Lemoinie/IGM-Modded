package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ObsidianShield extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_obsidian_shield_name;
        this.idDescription = R.string.accessory_obsidian_shield_description;
        this.idImage = R.drawable.obsidian_shield;
        this.price = 252L;
        this.constitution = 21;
    }
}
