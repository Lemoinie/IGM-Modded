package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ArmorOfTheUndying extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_armor_of_the_undying_name;
        this.idDescription = R.string.armor_heavy_armor_of_the_undying_description;
        this.idEffect = R.string.armor_heavy_armor_of_the_undying_effect;
        this.idImage = R.drawable.armor_of_the_undying;
        this.price = 49300L;
        this.onSelfHit = new StatusEffect(StatusEffectType.REGENERATION, null, 1, 1.0d);
        this.maxHp = 350;
        this.regenerationBonus = 5;
    }
}
