package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class ShahuriBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_shahuri_bow_name;
        this.idDescription = R.string.weapon_bow_shahuri_bow_description;
        this.idImage = R.drawable.shahuri_bow;
        this.idEffect = R.string.weapon_bow_shahuri_bow_effect;
        this.price = 86L;
        this.onTargetHit = new StatusEffect(StatusEffectType.STUN, null, 1, 0.05d);
        this.dexterity = 6;
        this.intelligence = 2;
    }
}
