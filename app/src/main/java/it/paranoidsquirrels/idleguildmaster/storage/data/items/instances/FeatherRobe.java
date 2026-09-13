package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class FeatherRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_feather_robe_name;
        this.idDescription = R.string.armor_light_feather_robe_description;
        this.idImage = R.drawable.feather_robe;
        this.price = 72L;
        this.maxHp = 20;
        this.intelligence = 6;
    }
}
