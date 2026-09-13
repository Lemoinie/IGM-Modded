package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class RobeOfTheArchmage extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_robe_of_the_archmage_name;
        this.idDescription = R.string.armor_light_robe_of_the_archmage_description;
        this.idImage = R.drawable.robe_of_the_archmage;
        this.price = 966L;
        this.maxHp = Logger.BARD_SHIELD;
        this.intelligence = 40;
        this.magicDefense = 6;
    }
}
