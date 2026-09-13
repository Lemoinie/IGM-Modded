package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class WinterCape extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_winter_cape_name;
        this.idDescription = R.string.armor_light_winter_cape_description;
        this.idImage = R.drawable.winter_cape;
        this.price = 486L;
        this.maxHp = 60;
        this.intelligence = 18;
    }
}
