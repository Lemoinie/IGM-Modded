package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ClothRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_cloth_robe_name;
        this.idDescription = R.string.armor_light_cloth_robe_description;
        this.idImage = R.drawable.cloth_robe;
        this.price = 54L;
        this.maxHp = 10;
        this.intelligence = 3;
    }
}
