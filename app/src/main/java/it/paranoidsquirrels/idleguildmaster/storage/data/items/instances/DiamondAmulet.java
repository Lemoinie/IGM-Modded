package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class DiamondAmulet extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_diamond_amulet_name;
        this.idDescription = R.string.accessory_diamond_amulet_description;
        this.idEffect = R.string.accessory_diamond_amulet_effect;
        this.idImage = R.drawable.diamond_amulet;
        this.price = 7503L;
        this.bonusExperience = 55;
        this.maxHp = 175;
    }
}
