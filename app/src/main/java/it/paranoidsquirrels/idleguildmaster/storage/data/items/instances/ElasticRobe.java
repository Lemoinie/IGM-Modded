package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ElasticRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_elastic_robe_name;
        this.idDescription = R.string.armor_light_elastic_robe_description;
        this.idImage = R.drawable.elastic_robe;
        this.price = 444L;
        this.maxHp = 90;
        this.intelligence = 27;
    }
}
