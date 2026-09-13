package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class GhastlyShield extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_ghastly_shield_name;
        this.idDescription = R.string.accessory_ghastly_shield_description;
        this.idEffect = R.string.accessory_ghastly_shield_effect;
        this.idImage = R.drawable.ghastly_shield;
        this.price = 155L;
        this.maxHp = 25;
        this.constitution = 9;
        this.magicDefense = 8;
        this.retaliationMagicalDamage = 10;
    }
}
