package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class ScarletOni : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_scarlet_oni_name
        idDescription = R.string.armor_heavy_scarlet_oni_description
        idEffect = R.string.armor_heavy_scarlet_oni_effect
        idImage = R.drawable.scarlet_oni
        price = 100000L
        maxHp = 470
        constitution = 56
        criticalChance = 0.18
        criticalDamage = 0.05
    }
}