package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class WinterwoodBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_winterwood_bow_name;
        this.idDescription = R.string.weapon_bow_winterwood_bow_description;
        this.idImage = R.drawable.winterwood_bow;
        this.price = 275L;
        this.intelligence = 5;
        this.dexterity = 19;
    }
}
