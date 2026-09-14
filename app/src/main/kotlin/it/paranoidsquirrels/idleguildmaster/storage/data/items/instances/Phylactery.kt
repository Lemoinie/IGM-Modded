package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class Phylactery : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_phylactery_name
        idDescription = R.string.accessory_phylactery_description
        idEffect = R.string.accessory_phylactery_effect
        idImage = R.drawable.phylactery
        price = 10100L
        maxHp = 80
        regenerationBonus = 5
    }
}
