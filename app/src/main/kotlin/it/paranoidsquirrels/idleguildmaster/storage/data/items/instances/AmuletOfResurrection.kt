package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class AmuletOfResurrection : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_amulet_of_resurrection_name
        idDescription = R.string.accessory_amulet_of_resurrection_description
        idEffect = R.string.accessory_amulet_of_resurrection_effect
        idImage = R.drawable.amulet_of_resurrection
        price = 7425L
    }
}
