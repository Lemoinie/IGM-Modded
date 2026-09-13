package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class MithrilSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_mithril_sword_name;
        this.idDescription = R.string.weapon_sword_mithril_sword_description;
        this.idImage = R.drawable.mithril_sword;
        this.price = 1020L;
        this.constitution = 33;
        this.dexterity = 11;
    }
}
