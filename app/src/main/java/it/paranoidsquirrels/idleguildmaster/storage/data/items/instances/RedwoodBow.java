package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class RedwoodBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_redwood_bow_name;
        this.idDescription = R.string.weapon_bow_redwood_bow_description;
        this.idImage = R.drawable.redwood_bow;
        this.price = 123L;
        this.constitution = 4;
        this.dexterity = 12;
    }
}
