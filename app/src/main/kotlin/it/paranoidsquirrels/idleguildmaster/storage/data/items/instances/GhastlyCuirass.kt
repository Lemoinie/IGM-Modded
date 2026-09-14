package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class GhastlyCuirass : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_ghastly_cuirass_name
        idDescription = R.string.armor_heavy_ghastly_cuirass_description
        idEffect = R.string.armor_heavy_ghastly_cuirass_effect
        idImage = R.drawable.ghastly_cuirass
        price = 1686L
        maxHp = 90
        constitution = 6
        magicDefense = 10
        threat = 1
    }
}
