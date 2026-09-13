package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatedBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_animated_bow_name;
        this.idDescription = R.string.weapon_bow_animated_bow_description;
        this.idImage = R.drawable.animated_bow;
        this.price = 638L;
        this.dexterity = 30;
        this.intelligence = 10;
    }
}
