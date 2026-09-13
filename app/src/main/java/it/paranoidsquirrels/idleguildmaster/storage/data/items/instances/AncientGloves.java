package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class AncientGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_ancient_gloves_name;
        this.idDescription = R.string.accessory_ancient_gloves_description;
        this.idImage = R.drawable.ancient_gloves;
        this.price = 468L;
        this.constitution = 27;
        this.dexterity = 22;
    }
}
