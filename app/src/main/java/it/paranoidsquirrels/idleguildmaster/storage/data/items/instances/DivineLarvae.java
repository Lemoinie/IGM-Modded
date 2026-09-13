package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class DivineLarvae extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_divine_larvae_name;
        this.idDescription = R.string.accessory_divine_larvae_description;
        this.idEffect = R.string.accessory_divine_larvae_effect;
        this.idImage = R.drawable.divine_larvae;
        this.price = 26130L;
        this.uniqueOrigin = "DivineEmbryo";
        this.notSellable = true;
        this.constitution = 25;
        this.dexterity = 25;
        this.intelligence = 25;
        this.immunityToStatus = 1.0d;
    }
}
