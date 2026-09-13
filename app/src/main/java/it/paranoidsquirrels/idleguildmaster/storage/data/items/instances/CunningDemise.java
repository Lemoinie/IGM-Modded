package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class CunningDemise extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_cunning_demise_name;
        this.idDescription = R.string.armor_medium_cunning_demise_description;
        this.idEffect = R.string.armor_medium_cunning_demise_effect;
        this.idImage = R.drawable.cunning_demise;
        this.price = 16200L;
        this.onTargetHit = new StatusEffect(StatusEffectType.SILENCE, null, 1, 0.125d);
        this.maxHp = 160;
        this.constitution = 7;
        this.dexterity = 7;
    }
}
