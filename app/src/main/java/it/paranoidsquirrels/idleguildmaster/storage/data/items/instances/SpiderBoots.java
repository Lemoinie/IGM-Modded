package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SpiderBoots extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_spider_boots_name;
        this.idDescription = R.string.accessory_spider_boots_description;
        this.idImage = R.drawable.spider_boots;
        this.price = 378L;
        this.dexterity = 21;
    }
}
