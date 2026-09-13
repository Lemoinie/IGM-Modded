package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable;

/* JADX INFO: loaded from: classes3.dex */
public class PotionOfClumsiness extends Consumable {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.consumable_potion_of_clumsiness_name;
        this.idDescription = R.string.consumable_potion_of_clumsiness_description;
        this.idImage = R.drawable.potion_of_clumsiness;
        this.source.add(Integer.valueOf(R.string.raid_name_kaunis));
        this.price = WorkRequest.MIN_BACKOFF_MILLIS;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
    public int printConsumeImage() {
        return R.drawable.consume_potion;
    }
}
