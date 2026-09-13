package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class StellarFlare extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_stellar_flare_name;
        this.idDescription = R.string.weapon_bow_stellar_flare_description;
        this.idEffect = R.string.weapon_bow_stellar_flare_effect;
        this.idImage = R.drawable.stellar_flare;
        this.price = 37350L;
        this.onTargetHit = new StatusEffect(StatusEffectType.STUN, null, 1, 0.13d);
        this.dexterity = 55;
        this.intelligence = 34;
    }
}
