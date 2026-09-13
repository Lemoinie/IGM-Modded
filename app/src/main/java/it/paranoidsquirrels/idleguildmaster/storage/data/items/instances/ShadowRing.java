package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ShadowRing extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_shadow_ring_name;
        this.idDescription = R.string.accessory_shadow_ring_description;
        this.idEffect = R.string.accessory_shadow_ring_effect;
        this.idImage = R.drawable.shadow_ring;
        this.price = 93L;
        this.dexterity = 24;
        this.initiative = true;
        this.criticalChance = 0.12d;
    }
}
