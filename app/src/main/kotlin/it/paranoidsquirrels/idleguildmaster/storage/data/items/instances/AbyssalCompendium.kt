package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class AbyssalCompendium : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_abyssal_compendium_name
        idDescription = R.string.accessory_abyssal_compendium_description
        idImage = R.drawable.abyssal_compendium
        price = 375L
        intelligence = 15
    }
}
