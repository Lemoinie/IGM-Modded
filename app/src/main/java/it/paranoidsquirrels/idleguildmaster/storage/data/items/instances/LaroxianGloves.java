package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class LaroxianGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_laroxian_gloves_name;
        this.idDescription = R.string.accessory_laroxian_gloves_description;
        this.idImage = R.drawable.laroxian_gloves;
        this.price = 393L;
        this.constitution = 25;
        this.dexterity = 20;
    }
}
