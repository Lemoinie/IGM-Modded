package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SilkRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_silk_robe_name;
        this.idDescription = R.string.armor_light_silk_robe_description;
        this.idImage = R.drawable.silk_robe;
        this.price = 216L;
        this.maxHp = 40;
        this.intelligence = 12;
    }
}
