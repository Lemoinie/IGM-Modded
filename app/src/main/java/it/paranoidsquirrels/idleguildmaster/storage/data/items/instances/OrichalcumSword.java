package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class OrichalcumSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_orichalcum_sword_name;
        this.idDescription = R.string.weapon_sword_orichalcum_sword_description;
        this.idImage = R.drawable.orichalcum_sword;
        this.price = 1440L;
        this.constitution = 39;
        this.dexterity = 13;
    }
}
