package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class AbsoluteZero extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_absolute_zero_name;
        this.idDescription = R.string.armor_heavy_absolute_zero_description;
        this.idEffect = R.string.armor_heavy_absolute_zero_effect;
        this.idImage = R.drawable.absolute_zero;
        this.price = 8889L;
        this.onSelfHit = new StatusEffect(StatusEffectType.FROZEN, null, 1, 1.0d);
        this.maxHp = 310;
        this.defense = 16;
    }
}
