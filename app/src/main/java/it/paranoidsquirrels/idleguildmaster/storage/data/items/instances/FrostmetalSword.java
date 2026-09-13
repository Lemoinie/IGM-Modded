package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class FrostmetalSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_frostmetal_sword_name;
        this.idDescription = R.string.weapon_sword_frostmetal_sword_description;
        this.idImage = R.drawable.frostmetal_sword;
        this.price = 513L;
        this.constitution = 18;
        this.dexterity = 6;
    }
}
