package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class CelestialArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_celestial_armor_name
        idDescription = R.string.armor_heavy_celestial_armor_description
        idImage = R.drawable.celestial_armor
        price = 653L
        maxHp = 270
        constitution = 9
    }
}
