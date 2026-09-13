package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.lifecycle.CoroutineLiveDataKt;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class EyesOfTheSwordsman extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_eyes_of_the_swordsman_name;
        this.idDescription = R.string.item_eyes_of_the_swordsman_description;
        this.idImage = R.drawable.eyes_of_the_swordsman;
        this.source.add(Integer.valueOf(R.string.raid_name_divine_archeology));
        this.uniqueOrigin = getTrueClass();
        this.notSellable = true;
        this.price = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    }
}
