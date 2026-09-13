package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class RobeOfTheLich extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_robe_of_the_lich_name;
        this.idDescription = R.string.armor_light_robe_of_the_lich_description;
        this.idEffect = R.string.armor_light_robe_of_the_lich_effect;
        this.idImage = R.drawable.robe_of_the_lich;
        this.source.add(Integer.valueOf(R.string.raid_name_ancient_grave_digging));
        this.price = 42500L;
        this.maxHp = 75;
        this.intelligence = 27;
        this.lifestealWithMinion = 35;
    }
}
