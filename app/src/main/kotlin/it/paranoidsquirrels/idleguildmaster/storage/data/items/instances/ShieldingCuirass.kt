package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class ShieldingCuirass : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_shielding_cuirass_name
        idDescription = R.string.armor_heavy_shielding_cuirass_description
        idEffect = R.string.armor_heavy_shielding_cuirass_effect
        idImage = R.drawable.shielding_cuirass
        price = 1224L
        immunityToStatus = 0.3
        maxHp = 300
        constitution = 15
    }
}
