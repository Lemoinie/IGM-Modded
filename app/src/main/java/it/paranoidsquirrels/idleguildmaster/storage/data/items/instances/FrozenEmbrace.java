package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class FrozenEmbrace extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_frozen_embrace_name;
        this.idDescription = R.string.armor_heavy_frozen_embrace_description;
        this.idEffect = R.string.armor_heavy_frozen_embrace_effect;
        this.idImage = R.drawable.frozen_embrace;
        this.price = 2457L;
        this.onSelfHit = new StatusEffect(StatusEffectType.FROZEN, null, 1, 1.0d);
        this.maxHp = 200;
        this.defense = 12;
    }
}
