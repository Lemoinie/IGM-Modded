package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class AncestralBlood extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_ancestral_blood_name;
        this.idDescription = R.string.item_ancestral_blood_description;
        this.idImage = R.drawable.ancestral_blood;
        this.source.add(Integer.valueOf(R.string.raid_name_the_tower));
        this.price = 1000L;
    }
}
