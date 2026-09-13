package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SeekingGlass extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_seeking_glass_name;
        this.idDescription = R.string.accessory_seeking_glass_description;
        this.idEffect = R.string.accessory_seeking_glass_effect;
        this.idImage = R.drawable.seeking_glass;
        this.source.add(Integer.valueOf(R.string.raid_name_the_slime_pond));
        this.price = WorkRequest.MIN_BACKOFF_MILLIS;
        this.alwaysHits = true;
        this.intelligence = 25;
    }
}
