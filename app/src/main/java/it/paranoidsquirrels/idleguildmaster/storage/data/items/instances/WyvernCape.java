package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class WyvernCape extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_wyvern_cape_name;
        this.idDescription = R.string.armor_light_wyvern_cape_description;
        this.idEffect = R.string.armor_light_wyvern_cape_effect;
        this.idImage = R.drawable.wyvern_cape;
        this.price = 630L;
        this.maxHp = 80;
        this.intelligence = 15;
        this.healingModifier = 0.15d;
    }
}
