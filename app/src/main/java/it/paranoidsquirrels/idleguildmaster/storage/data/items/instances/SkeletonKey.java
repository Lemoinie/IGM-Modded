package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SkeletonKey extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_skeleton_key_name;
        this.idDescription = R.string.accessory_skeleton_key_description;
        this.idEffect = R.string.accessory_skeleton_key_effect;
        this.idImage = R.drawable.skeleton_key;
        this.source.add(Integer.valueOf(R.string.raid_name_imperial_rescue));
        this.price = 35L;
        this.uniqueOrigin = getTrueClass();
        this.notSellable = true;
        this.intelligence = 36;
    }
}
