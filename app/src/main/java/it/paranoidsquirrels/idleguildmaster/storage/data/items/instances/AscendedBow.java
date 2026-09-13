package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class AscendedBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_ascended_bow_name;
        this.idDescription = R.string.weapon_bow_ascended_bow_description;
        this.idEffect = R.string.weapon_bow_ascended_bow_effect;
        this.idImage = R.drawable.ascended_bow;
        this.price = 279L;
        this.onTargetHit = new StatusEffect(StatusEffectType.STUN, null, 1, 0.075d);
        this.dexterity = 8;
        this.intelligence = 6;
    }
}
