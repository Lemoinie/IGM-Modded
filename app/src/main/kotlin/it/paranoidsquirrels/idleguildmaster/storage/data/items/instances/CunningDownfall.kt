package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class CunningDownfall : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_cunning_downfall_name
        idDescription = R.string.armor_medium_cunning_downfall_description
        idEffect = R.string.armor_medium_cunning_downfall_effect
        idImage = R.drawable.cunning_downfall
        price = 4320L
        onTargetHit = StatusEffect(StatusEffectType.SILENCE, null, 1, 0.1)
        maxHp = 140
        constitution = 5
        dexterity = 5
    }
}
