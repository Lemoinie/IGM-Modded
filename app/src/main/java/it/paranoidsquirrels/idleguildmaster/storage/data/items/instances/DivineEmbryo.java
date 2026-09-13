package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class DivineEmbryo extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_divine_embryo_name;
        this.idDescription = R.string.accessory_divine_embryo_description;
        this.idEffect = R.string.accessory_divine_embryo_effect;
        this.idImage = R.drawable.divine_embryo;
        this.price = 17400L;
        this.uniqueOrigin = "DivineZygote";
        this.notSellable = true;
        this.constitution = 20;
        this.dexterity = 20;
        this.intelligence = 20;
        this.immunityToStatus = 1.0d;
    }
}
