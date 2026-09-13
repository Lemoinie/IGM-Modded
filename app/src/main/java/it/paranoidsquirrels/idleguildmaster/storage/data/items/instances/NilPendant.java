package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class NilPendant extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_nil_pendant_name;
        this.idDescription = R.string.accessory_nil_pendant_description;
        this.idEffect = R.string.accessory_nil_pendant_effect;
        this.idImage = R.drawable.nil_pendant;
        this.price = 47925L;
        this.bonusExperience = 100;
    }
}
