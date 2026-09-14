package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class CelestialSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_celestial_sword_name
        idDescription = R.string.weapon_sword_celestial_sword_description
        idImage = R.drawable.celestial_sword
        price = 581L
        constitution = 28
        dexterity = 8
    }
}
