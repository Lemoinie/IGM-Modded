package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class GhostwoodShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_ghostwood_shield_name
        idDescription = R.string.accessory_ghostwood_shield_description
        idImage = R.drawable.ghostwood_shield
        price = 203L
        constitution = 15
    }
}
