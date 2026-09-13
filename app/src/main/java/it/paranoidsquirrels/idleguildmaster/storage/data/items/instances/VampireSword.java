package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class VampireSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_vampire_sword_name;
        this.idDescription = R.string.weapon_sword_vampire_sword_description;
        this.idEffect = R.string.weapon_sword_vampire_sword_effect;
        this.idImage = R.drawable.vampire_sword;
        this.price = 1026L;
        this.constitution = 21;
        this.dexterity = 7;
        this.lifesteal = 20;
    }
}
