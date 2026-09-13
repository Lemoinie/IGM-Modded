package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ObsidianHelm extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_obsidian_helm_name;
        this.idDescription = R.string.accessory_obsidian_helm_description;
        this.idImage = R.drawable.obsidian_helm;
        this.price = 270L;
        this.maxHp = 140;
    }
}
