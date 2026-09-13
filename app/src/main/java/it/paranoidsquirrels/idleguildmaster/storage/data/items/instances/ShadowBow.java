package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class ShadowBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_shadow_bow_name;
        this.idDescription = R.string.weapon_bow_shadow_bow_description;
        this.idEffect = R.string.weapon_bow_shadow_bow_effect;
        this.idImage = R.drawable.shadow_bow;
        this.price = 1386L;
        this.intelligence = 6;
        this.dexterity = 22;
        this.darknessDamageAmplification = 0.005d;
    }
}
