package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class Sha extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_sha_name;
        this.idDescription = R.string.accessory_sha_description;
        this.idEffect = R.string.accessory_sha_effect;
        this.idImage = R.drawable.sha;
        this.price = 69150L;
        this.uniqueOrigin = "DivineLarvae";
        this.notSellable = true;
        this.constitution = 40;
        this.dexterity = 40;
        this.intelligence = 40;
        this.immunityToStatus = 1.0d;
    }
}
