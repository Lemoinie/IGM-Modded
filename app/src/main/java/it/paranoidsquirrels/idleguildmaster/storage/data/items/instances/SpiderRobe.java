package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SpiderRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_spider_robe_name;
        this.idDescription = R.string.armor_light_spider_robe_description;
        this.idImage = R.drawable.spider_robe;
        this.price = 540L;
        this.maxHp = 70;
        this.intelligence = 21;
    }
}
