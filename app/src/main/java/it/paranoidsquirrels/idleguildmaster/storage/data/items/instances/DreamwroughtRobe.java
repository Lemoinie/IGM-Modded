package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_dreamwrought_robe_name;
        this.idDescription = R.string.armor_light_dreamwrought_robe_description;
        this.idImage = R.drawable.dreamwrought_robe;
        this.price = 690L;
        this.maxHp = 46;
        this.intelligence = 60;
    }
}
