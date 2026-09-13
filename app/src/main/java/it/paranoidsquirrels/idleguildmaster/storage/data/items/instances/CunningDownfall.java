package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class CunningDownfall extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_cunning_downfall_name;
        this.idDescription = R.string.armor_medium_cunning_downfall_description;
        this.idEffect = R.string.armor_medium_cunning_downfall_effect;
        this.idImage = R.drawable.cunning_downfall;
        this.price = 4320L;
        this.onTargetHit = new StatusEffect(StatusEffectType.SILENCE, null, 1, 0.1d);
        this.maxHp = 140;
        this.constitution = 5;
        this.dexterity = 5;
    }
}
