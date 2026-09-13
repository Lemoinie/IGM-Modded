package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class GhostwoodBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_ghostwood_bow_name;
        this.idDescription = R.string.weapon_bow_ghostwood_bow_description;
        this.idImage = R.drawable.ghostwood_bow;
        this.price = 248L;
        this.intelligence = 4;
        this.dexterity = 16;
    }
}
