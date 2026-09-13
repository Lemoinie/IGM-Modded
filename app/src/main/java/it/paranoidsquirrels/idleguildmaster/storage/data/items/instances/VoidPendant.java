package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class VoidPendant extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_void_pendant_name;
        this.idDescription = R.string.accessory_void_pendant_description;
        this.idEffect = R.string.accessory_void_pendant_effect;
        this.idImage = R.drawable.void_pendant;
        this.price = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.bonusExperience = 80;
    }
}
