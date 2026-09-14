package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class AncientEye : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_ancient_eye_name
        idDescription = R.string.accessory_ancient_eye_description
        idEffect = R.string.accessory_ancient_eye_effect
        idImage = R.drawable.ancient_eye
        price = 1L
        immunityToStatus = 1.0
        constitution = 35
        dexterity = 35
    }
}
