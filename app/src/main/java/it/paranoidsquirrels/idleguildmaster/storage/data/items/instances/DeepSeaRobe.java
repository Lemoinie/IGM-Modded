package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class DeepSeaRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_deep_sea_robe_name;
        this.idDescription = R.string.armor_light_deep_sea_robe_description;
        this.idEffect = R.string.armor_light_deep_sea_robe_effect;
        this.idImage = R.drawable.deep_sea_robe;
        this.price = 5505L;
        this.maxHp = 50;
        this.intelligence = 15;
        this.immunityToStatus = 0.4d;
    }
}
