package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ChiefScientistCoat extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_chief_scientist_coat_name;
        this.idDescription = R.string.armor_light_chief_scientist_coat_description;
        this.idEffect = R.string.armor_light_chief_scientist_coat_effect;
        this.idImage = R.drawable.chief_scientist_coat;
        this.source.add(Integer.valueOf(R.string.raid_name_kaunis));
        this.price = 17500L;
        this.healingModifier = 0.25d;
        this.intelligence = 72;
    }
}
