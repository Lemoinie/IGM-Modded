package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class BlackIronCutlass extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_black_iron_cutlass_name;
        this.idDescription = R.string.weapon_sword_black_iron_cutlass_description;
        this.idImage = R.drawable.black_iron_cutlass;
        this.price = 362L;
        this.constitution = 15;
        this.dexterity = 5;
    }
}
