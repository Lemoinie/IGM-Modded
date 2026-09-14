package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class NilPendant : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_nil_pendant_name
        idDescription = R.string.accessory_nil_pendant_description
        idEffect = R.string.accessory_nil_pendant_effect
        idImage = R.drawable.nil_pendant
        price = 47925L
        bonusExperience = 100
    }
}
