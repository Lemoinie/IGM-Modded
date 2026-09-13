package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class Oblivion extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_oblivion_name;
        this.idDescription = R.string.weapon_bow_oblivion_description;
        this.idEffect = R.string.weapon_bow_oblivion_effect;
        this.idImage = R.drawable.oblivion;
        this.price = 67200L;
        this.onTargetHit = new StatusEffect(StatusEffectType.STUN, null, 1, 0.14d);
        this.dexterity = 70;
        this.intelligence = 42;
    }
}
