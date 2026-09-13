package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class EyeOfUr extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_eye_of_ur_name;
        this.idDescription = R.string.accessory_eye_of_ur_description;
        this.idEffect = R.string.accessory_eye_of_ur_effect;
        this.idImage = R.drawable.eye_of_ur;
        this.price = 0L;
        this.immunityToStatus = 1.0d;
        this.constitution = 15;
        this.dexterity = 15;
    }
}
