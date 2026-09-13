package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class Phylactery extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_phylactery_name;
        this.idDescription = R.string.accessory_phylactery_description;
        this.idEffect = R.string.accessory_phylactery_effect;
        this.idImage = R.drawable.phylactery;
        this.price = 10100L;
        this.maxHp = 80;
        this.regenerationBonus = 5;
    }
}
