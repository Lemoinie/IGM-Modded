package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_dreamwrought_bow_name;
        this.idDescription = R.string.weapon_bow_dreamwrought_bow_description;
        this.idImage = R.drawable.dreamwrought_bow;
        this.price = 1055L;
        this.dexterity = 39;
        this.intelligence = 13;
    }
}
