package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class TuskNecklace : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_tusk_necklace_name
        idDescription = R.string.accessory_tusk_necklace_description
        idImage = R.drawable.tusk_necklace
        price = 15L
        constitution = 1
        dexterity = 1
        intelligence = 1
    }
}
