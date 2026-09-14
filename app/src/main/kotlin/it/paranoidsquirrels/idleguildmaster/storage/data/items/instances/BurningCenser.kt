package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class BurningCenser : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_burning_censer_name
        idDescription = R.string.accessory_burning_censer_description
        idEffect = R.string.accessory_burning_censer_effect
        idImage = R.drawable.burning_censer
        price = 564L
        intelligence = 12
        darknessReduction = 10
        healingModifier = 0.2
    }
}
