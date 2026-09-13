package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ExoticRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_exotic_robe_name;
        this.idDescription = R.string.armor_light_exotic_robe_description;
        this.idImage = R.drawable.exotic_robe;
        this.price = 1350L;
        this.maxHp = 50;
        this.intelligence = 15;
    }
}
