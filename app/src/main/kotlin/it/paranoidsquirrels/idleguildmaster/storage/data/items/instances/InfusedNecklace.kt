package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class InfusedNecklace : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_infused_necklace_name
        idDescription = R.string.accessory_infused_necklace_description
        idEffect = R.string.accessory_infused_necklace_effect
        idImage = R.drawable.infused_necklace
        price = 38L
        constitution = 1
        dexterity = 1
        intelligence = 2
        bonusExperience = 10
    }
}
