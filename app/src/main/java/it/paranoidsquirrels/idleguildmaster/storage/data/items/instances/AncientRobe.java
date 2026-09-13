package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class AncientRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_ancient_robe_name;
        this.idDescription = R.string.armor_light_ancient_robe_description;
        this.idImage = R.drawable.ancient_robe;
        this.price = 600L;
        this.maxHp = Logger.STATUS_FEEBLE_TETHER;
        this.intelligence = 33;
    }
}
