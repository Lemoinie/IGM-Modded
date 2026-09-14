package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class CelestialBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_celestial_bow_name
        idDescription = R.string.weapon_bow_celestial_bow_description
        idEffect = R.string.weapon_bow_celestial_bow_effect
        idImage = R.drawable.celestial_bow
        price = 30000L
        dexterity = 40
        intelligence = 15
        criticalChance = 0.10
        criticalDamage = 0.10
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK
    }
}
