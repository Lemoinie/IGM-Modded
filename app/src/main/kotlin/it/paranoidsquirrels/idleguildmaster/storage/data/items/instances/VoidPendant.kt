package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class VoidPendant : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_void_pendant_name
        idDescription = R.string.accessory_void_pendant_description
        idEffect = R.string.accessory_void_pendant_effect
        idImage = R.drawable.void_pendant
        price = 30000L
        bonusExperience = 80
    }
}
