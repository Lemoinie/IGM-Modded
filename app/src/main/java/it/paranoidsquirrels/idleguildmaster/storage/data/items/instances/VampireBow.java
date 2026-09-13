package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class VampireBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_vampire_bow_name;
        this.idDescription = R.string.weapon_bow_vampire_bow_description;
        this.idEffect = R.string.weapon_bow_vampire_bow_effect;
        this.idImage = R.drawable.vampire_bow;
        this.price = 1040L;
        this.intelligence = 6;
        this.dexterity = 22;
        this.lifesteal = 20;
    }
}
