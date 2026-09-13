package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class DjinnTonic extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_djinn_tonic_name;
        this.idDescription = R.string.accessory_djinn_tonic_description;
        this.idEffect = R.string.accessory_djinn_tonic_effect;
        this.idImage = R.drawable.djinn_tonic;
        this.price = 233L;
        this.maxHp = 15;
        this.constitution = 4;
        this.intelligence = 4;
        this.immunityToStatus = 0.2d;
    }
}
