package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class CelestialMercy : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_celestial_mercy_name
        idDescription = R.string.weapon_sword_celestial_mercy_description
        idEffect = R.string.weapon_sword_celestial_mercy_effect
        idImage = R.drawable.celestials_mercy
        price = 1100L
        darknessReduction = 12
        alwaysHits = true
        constitution = 28
        dexterity = 8
    }
}
