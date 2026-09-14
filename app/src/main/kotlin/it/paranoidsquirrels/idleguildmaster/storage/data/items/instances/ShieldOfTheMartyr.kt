package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ShieldOfTheMartyr : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_shield_of_the_martyr_name
        idDescription = R.string.accessory_shield_of_the_martyr_description
        idEffect = R.string.accessory_shield_of_the_martyr_effect
        idImage = R.drawable.shield_of_the_martyr
        price = 26500L
        constitution = 22
        defense = 8
        magicDefense = 8
        threat = 2
    }
}
