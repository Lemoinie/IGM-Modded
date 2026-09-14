package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class DreamwroughtArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_dreamwrought_armor_name
        idDescription = R.string.armor_heavy_dreamwrought_armor_description
        idImage = R.drawable.dreamwrought_armor
        price = 1245L
        maxHp = 338
        constitution = 26
    }
}
