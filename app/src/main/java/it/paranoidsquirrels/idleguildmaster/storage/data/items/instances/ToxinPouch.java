package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ToxinPouch extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_toxin_pouch_name;
        this.idDescription = R.string.accessory_toxin_pouch_description;
        this.idEffect = R.string.accessory_toxin_pouch_effect;
        this.idImage = R.drawable.toxin_pouch;
        this.price = 654L;
        this.poisonBonus = 4;
        this.maxHp = 90;
        this.intelligence = 15;
    }
}
