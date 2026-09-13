package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatedHelm extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_animated_helm_name;
        this.idDescription = R.string.accessory_animated_helm_description;
        this.idImage = R.drawable.animated_helm;
        this.price = 471L;
        this.maxHp = 200;
    }
}
