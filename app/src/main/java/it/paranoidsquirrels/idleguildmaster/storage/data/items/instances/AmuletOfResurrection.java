package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class AmuletOfResurrection extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_amulet_of_resurrection_name;
        this.idDescription = R.string.accessory_amulet_of_resurrection_description;
        this.idEffect = R.string.accessory_amulet_of_resurrection_effect;
        this.idImage = R.drawable.amulet_of_resurrection;
        this.price = 7425L;
    }
}
