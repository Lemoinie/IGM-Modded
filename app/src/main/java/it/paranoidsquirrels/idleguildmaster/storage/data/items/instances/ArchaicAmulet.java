package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ArchaicAmulet extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_archaic_amulet_name;
        this.idDescription = R.string.accessory_archaic_amulet_description;
        this.idEffect = R.string.accessory_archaic_amulet_effect;
        this.idImage = R.drawable.archaic_amulet;
        this.price = 806L;
        this.livingCompanionBonusDamage = 40;
        this.maxHp = 140;
    }
}
