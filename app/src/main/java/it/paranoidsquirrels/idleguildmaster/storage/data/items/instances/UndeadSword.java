package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class UndeadSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_undead_sword_name;
        this.idDescription = R.string.weapon_sword_undead_sword_description;
        this.idImage = R.drawable.undead_sword;
        this.price = 54L;
        this.constitution = 9;
        this.dexterity = 3;
    }
}
