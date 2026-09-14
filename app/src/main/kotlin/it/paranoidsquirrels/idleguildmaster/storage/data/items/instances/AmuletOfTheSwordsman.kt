package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class AmuletOfTheSwordsman : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_amulet_of_the_swordsman_name
        idDescription = R.string.accessory_amulet_of_the_swordsman_description
        idEffect = R.string.accessory_amulet_of_the_swordsman_effect
        idImage = R.drawable.amulet_of_the_swordsman
        price = 7590L
        uniqueOrigin = "EyesOfTheSwordsman"
        notSellable = true
        constitution = 25
        counterattack = 0.25
        alwaysHits = true
    }
}
