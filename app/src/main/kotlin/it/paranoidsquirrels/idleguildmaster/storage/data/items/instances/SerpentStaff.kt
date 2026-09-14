package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class SerpentStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_serpent_staff_name
        idDescription = R.string.weapon_staff_serpent_staff_description
        idEffect = R.string.weapon_staff_serpent_staff_effect
        idImage = R.drawable.serpent_staff
        source.add(R.string.raid_name_the_dreadful_ascent)
        price = 10000L
        uniqueOrigin = getTrueClass()
        notSellable = true
        onTargetHit = StatusEffect(StatusEffectType.FRENZY, null, 3, 1.0)
        intelligence = 40
        healingModifier = -0.5
    }
}
