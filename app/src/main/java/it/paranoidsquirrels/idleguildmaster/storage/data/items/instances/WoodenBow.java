package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class WoodenBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_wooden_bow_name;
        this.idDescription = R.string.weapon_bow_wooden_bow_description;
        this.idImage = R.drawable.wooden_bow;
        this.price = 11L;
        this.constitution = 1;
        this.dexterity = 3;
    }
}
