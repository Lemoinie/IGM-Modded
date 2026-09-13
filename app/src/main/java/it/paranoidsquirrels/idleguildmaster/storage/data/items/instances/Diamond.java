package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.lifecycle.CoroutineLiveDataKt;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class Diamond extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_diamond_name;
        this.idDescription = R.string.item_diamond_description;
        this.idImage = R.drawable.diamond;
        this.source.add(Integer.valueOf(R.string.dungeon_name_lost_lands));
        this.price = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    }
}
