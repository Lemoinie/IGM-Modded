package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class EyeOfUr : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_eye_of_ur_name
        idDescription = R.string.accessory_eye_of_ur_description
        idEffect = R.string.accessory_eye_of_ur_effect
        idImage = R.drawable.eye_of_ur
        price = 0L
        immunityToStatus = 1.0
        constitution = 15
        dexterity = 15
    }
}
