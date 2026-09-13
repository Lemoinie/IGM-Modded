package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class UnholySword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_unholy_sword_name;
        this.idDescription = R.string.weapon_sword_unholy_sword_description;
        this.idEffect = R.string.weapon_sword_unholy_sword_effect;
        this.idImage = R.drawable.unholy_sword;
        this.price = 1485L;
        this.constitution = 27;
        this.dexterity = 5;
        this.retaliationMagicalDamage = 15;
    }
}
