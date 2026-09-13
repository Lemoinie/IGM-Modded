package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class KaunianRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_kaunian_robe_name;
        this.idDescription = R.string.armor_light_kaunian_robe_description;
        this.idImage = R.drawable.kaunian_robe;
        this.price = 900L;
        this.maxHp = 206;
        this.intelligence = 20;
    }
}
