package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class JeweledCrown : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_jeweled_crown_name
        idDescription = R.string.accessory_jeweled_crown_description
        idEffect = R.string.accessory_jeweled_crown_effect
        idImage = R.drawable.jeweled_crown
        price = 2790L
        initiative = true
        alwaysHits = true
        defense = 10
        magicDefense = 10
    }
}
