package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class GoldenSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_golden_sword_name;
        this.idDescription = R.string.weapon_sword_golden_sword_description;
        this.idImage = R.drawable.golden_sword;
        this.price = 483L;
        this.constitution = 12;
        this.dexterity = 4;
    }
}
