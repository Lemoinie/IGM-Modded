package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class CopperSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_copper_sword_name;
        this.idDescription = R.string.weapon_sword_copper_sword_description;
        this.idImage = R.drawable.copper_sword;
        this.price = 20L;
        this.constitution = 3;
        this.dexterity = 1;
    }
}
