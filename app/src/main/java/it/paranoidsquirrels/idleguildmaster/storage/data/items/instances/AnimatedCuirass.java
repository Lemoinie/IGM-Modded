package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatedCuirass extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_animated_cuirass_name;
        this.idDescription = R.string.armor_heavy_animated_cuirass_description;
        this.idImage = R.drawable.animated_cuirass;
        this.price = 756L;
        this.maxHp = 300;
        this.constitution = 10;
    }
}
