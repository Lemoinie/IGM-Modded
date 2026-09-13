package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class BansheeGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_banshee_gloves_name;
        this.idDescription = R.string.accessory_banshee_gloves_description;
        this.idImage = R.drawable.banshee_gloves;
        this.price = 468L;
        this.constitution = 22;
        this.dexterity = 18;
    }
}
