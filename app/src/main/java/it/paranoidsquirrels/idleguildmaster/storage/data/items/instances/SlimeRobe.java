package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SlimeRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_slime_robe_name;
        this.idDescription = R.string.armor_light_slime_robe_description;
        this.idImage = R.drawable.slime_robe;
        this.price = 630L;
        this.maxHp = 80;
        this.defense = 5;
    }
}
