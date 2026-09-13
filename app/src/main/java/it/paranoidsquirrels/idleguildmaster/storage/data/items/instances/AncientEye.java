package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class AncientEye extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_ancient_eye_name;
        this.idDescription = R.string.accessory_ancient_eye_description;
        this.idEffect = R.string.accessory_ancient_eye_effect;
        this.idImage = R.drawable.ancient_eye;
        this.price = 1L;
        this.immunityToStatus = 1.0d;
        this.constitution = 35;
        this.dexterity = 35;
    }
}
