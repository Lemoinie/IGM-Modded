package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class CunningDemise : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_cunning_demise_name
        idDescription = R.string.armor_medium_cunning_demise_description
        idEffect = R.string.armor_medium_cunning_demise_effect
        idImage = R.drawable.cunning_demise
        price = 16200L
        onTargetHit = StatusEffect(StatusEffectType.SILENCE, null, 1, 0.125)
        maxHp = 160
        constitution = 7
        dexterity = 7
    }
}
