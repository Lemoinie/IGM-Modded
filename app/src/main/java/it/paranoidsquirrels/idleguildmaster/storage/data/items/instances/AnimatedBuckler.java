package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatedBuckler extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_animated_bucker_name;
        this.idDescription = R.string.accessory_animated_bucker_description;
        this.idImage = R.drawable.animated_buckler;
        this.price = 500L;
        this.constitution = 30;
    }
}
