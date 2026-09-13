package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.lifecycle.CoroutineLiveDataKt;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class ExaltedPowder extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_exalted_powder_name;
        this.idDescription = R.string.item_exalted_powder_description;
        this.idImage = R.drawable.exalted_powder;
        this.source.add(Integer.valueOf(R.string.raid_name_the_cultist_rebels));
        this.price = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    }
}
