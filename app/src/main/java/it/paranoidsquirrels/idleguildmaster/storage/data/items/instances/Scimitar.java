package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class Scimitar extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_scimitar_name;
        this.idDescription = R.string.weapon_sword_scimitar_description;
        this.idImage = R.drawable.scimitar;
        this.price = 41L;
        this.constitution = 6;
        this.dexterity = 2;
    }
}
