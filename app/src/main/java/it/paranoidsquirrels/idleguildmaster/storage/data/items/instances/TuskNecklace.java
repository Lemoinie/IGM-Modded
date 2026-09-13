package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class TuskNecklace extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_tusk_necklace_name;
        this.idDescription = R.string.accessory_tusk_necklace_description;
        this.idImage = R.drawable.tusk_necklace;
        this.price = 15L;
        this.constitution = 1;
        this.dexterity = 1;
        this.intelligence = 1;
    }
}
