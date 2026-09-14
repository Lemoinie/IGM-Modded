package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class DiamondAmulet : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_diamond_amulet_name
        idDescription = R.string.accessory_diamond_amulet_description
        idEffect = R.string.accessory_diamond_amulet_effect
        idImage = R.drawable.diamond_amulet
        price = 7503L
        bonusExperience = 55
        maxHp = 175
    }
}
