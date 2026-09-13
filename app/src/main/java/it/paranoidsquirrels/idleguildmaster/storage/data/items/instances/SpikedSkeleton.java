package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SpikedSkeleton extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_spiked_skeleton_name;
        this.idDescription = R.string.armor_heavy_spiked_skeleton_description;
        this.idEffect = R.string.armor_heavy_spiked_skeleton_effect;
        this.idImage = R.drawable.spiked_skeleton;
        this.price = 0L;
        this.retaliationPhysicalDamage = 50;
        this.constitution = 8;
    }
}
