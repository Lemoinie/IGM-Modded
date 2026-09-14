package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class UnholyCuirass : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_unholy_cuirass_name
        idDescription = R.string.armor_heavy_unholy_cuirass_description
        idEffect = R.string.armor_heavy_unholy_cuirass_effect
        idImage = R.drawable.unholy_cuirass
        price = 1607L
        maxHp = 230
        constitution = 8
        retaliationMagicalDamage = 15
    }
}
