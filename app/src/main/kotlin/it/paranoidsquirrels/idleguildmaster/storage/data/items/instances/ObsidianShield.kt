package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ObsidianShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_obsidian_shield_name
        idDescription = R.string.accessory_obsidian_shield_description
        idImage = R.drawable.obsidian_shield
        price = 252L
        constitution = 21
    }
}
