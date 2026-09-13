package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class LaroxianRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_laroxian_robe_name;
        this.idDescription = R.string.armor_light_laroxian_robe_description;
        this.idImage = R.drawable.laroxian_robe;
        this.price = 504L;
        this.maxHp = 100;
        this.intelligence = 30;
    }
}
