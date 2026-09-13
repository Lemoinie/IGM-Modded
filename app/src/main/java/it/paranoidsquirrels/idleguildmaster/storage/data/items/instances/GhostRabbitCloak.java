package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class GhostRabbitCloak extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_ghost_rabbit_cloak_name;
        this.idDescription = R.string.armor_light_ghost_rabbit_cloak_description;
        this.idEffect = R.string.armor_light_ghost_rabbit_cloak_effect;
        this.idImage = R.drawable.ghost_rabbit_cloak;
        this.price = 390L;
        this.maxHp = 30;
        this.intelligence = 9;
        this.bonusExperience = 35;
    }
}
