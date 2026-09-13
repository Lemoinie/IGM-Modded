package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class TitanicMight extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_titanic_might_name;
        this.idDescription = R.string.weapon_bow_titanic_might_description;
        this.idEffect = R.string.weapon_bow_titanic_might_effect;
        this.idImage = R.drawable.titanic_might;
        this.price = 22400L;
        this.onTargetHit = new StatusEffect(StatusEffectType.STUN, null, 1, 0.11d);
        this.dexterity = 32;
        this.intelligence = 20;
    }
}
