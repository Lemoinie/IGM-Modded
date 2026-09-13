package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class DivineZygote extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_divine_zygote_name;
        this.idDescription = R.string.accessory_divine_zygote_description;
        this.idEffect = R.string.accessory_divine_zygote_effect;
        this.idImage = R.drawable.divine_zygote;
        this.source.add(Integer.valueOf(R.string.raid_name_divine_archeology));
        this.price = WorkRequest.MIN_BACKOFF_MILLIS;
        this.uniqueOrigin = getTrueClass();
        this.notSellable = true;
        this.constitution = 7;
        this.dexterity = 7;
        this.intelligence = 7;
        this.immunityToStatus = 1.0d;
    }
}
