package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class EmeraldRing extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_emerald_ring_name;
        this.idDescription = R.string.accessory_emerald_ring_description;
        this.idEffect = R.string.accessory_emerald_ring_effect;
        this.idImage = R.drawable.emerald_ring;
        this.price = 147L;
        this.initiative = true;
        this.magicDefense = 10;
    }
}
