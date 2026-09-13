package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class FrozenEggPendant extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_frozen_egg_pendant_name;
        this.idDescription = R.string.accessory_frozen_egg_pendant_description;
        this.idEffect = R.string.accessory_frozen_egg_pendant_effect;
        this.idImage = R.drawable.frozen_egg_pendant;
        this.price = 341L;
        this.freezeBonusDamage = 40;
        this.maxHp = 90;
        this.defense = 7;
    }
}
