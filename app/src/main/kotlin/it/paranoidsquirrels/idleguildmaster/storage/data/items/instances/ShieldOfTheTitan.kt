package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ShieldOfTheTitan : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_shield_of_the_titan_name
        idDescription = R.string.accessory_shield_of_the_titan_description
        idEffect = R.string.accessory_shield_of_the_titan_effect
        idImage = R.drawable.shield_of_the_titan
        price = 2700L
        constitution = 16
        defense = 5
        magicDefense = 5
        threat = 1
    }
}
