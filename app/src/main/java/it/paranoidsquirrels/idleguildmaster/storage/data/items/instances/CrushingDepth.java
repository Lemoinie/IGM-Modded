package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class CrushingDepth extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_crushing_depth_name;
        this.idDescription = R.string.weapon_bow_crushing_depth_description;
        this.idEffect = R.string.weapon_bow_crushing_depth_effect;
        this.idImage = R.drawable.crushing_depth;
        this.price = 4596L;
        this.onTargetHit = new StatusEffect(StatusEffectType.STUN, null, 1, 0.1d);
        this.dexterity = 18;
        this.intelligence = 13;
    }
}
