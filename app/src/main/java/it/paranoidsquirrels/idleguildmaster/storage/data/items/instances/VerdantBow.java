package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class VerdantBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_verdant_bow_name;
        this.idDescription = R.string.weapon_bow_verdant_bow_description;
        this.idImage = R.drawable.verdant_bow;
        this.price = 600L;
        this.intelligence = 8;
        this.dexterity = 24;
    }
}
