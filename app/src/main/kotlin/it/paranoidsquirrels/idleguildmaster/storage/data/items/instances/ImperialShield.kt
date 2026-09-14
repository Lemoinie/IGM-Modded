package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ImperialShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_imperial_shield_name
        idDescription = R.string.accessory_imperial_shield_description
        idImage = R.drawable.imperial_shield
        price = 564L
        constitution = 16
        dexterity = 5
        defense = 15
    }
}
