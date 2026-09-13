package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class BreathtakingRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_breathtaking_robe_name;
        this.idDescription = R.string.armor_light_breathtaking_robe_description;
        this.idEffect = R.string.armor_light_breathtaking_robe_effect;
        this.idImage = R.drawable.breathtaking_robe;
        this.price = 1859L;
        this.onSelfHit = new StatusEffect(StatusEffectType.SILENCE, null, 2, 1.0d);
        this.maxHp = 100;
        this.intelligence = 25;
    }
}
