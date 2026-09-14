package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class UndeadShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_undead_shield_name
        idDescription = R.string.accessory_undead_shield_description
        idImage = R.drawable.undead_shield
        price = 53L
        constitution = 9
    }
}
