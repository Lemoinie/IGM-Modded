package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatedSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_animated_sword_name;
        this.idDescription = R.string.weapon_sword_animated_sword_description;
        this.idImage = R.drawable.animated_sword;
        this.price = 635L;
        this.constitution = 30;
        this.dexterity = 10;
    }
}
