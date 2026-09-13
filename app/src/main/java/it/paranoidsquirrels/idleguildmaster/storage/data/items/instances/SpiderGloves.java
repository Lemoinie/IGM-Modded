package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SpiderGloves extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_spider_gloves_name;
        this.idDescription = R.string.accessory_spider_gloves_description;
        this.idImage = R.drawable.spider_gloves;
        this.price = 378L;
        this.constitution = 17;
        this.dexterity = 14;
    }
}
