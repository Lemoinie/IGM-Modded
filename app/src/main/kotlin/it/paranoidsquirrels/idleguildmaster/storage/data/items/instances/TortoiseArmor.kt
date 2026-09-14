package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class TortoiseArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_tortoise_armor_name
        idDescription = R.string.armor_heavy_tortoise_armor_description
        idImage = R.drawable.tortoise_armor
        price = 492L
        maxHp = 240
        constitution = 8
    }
}
