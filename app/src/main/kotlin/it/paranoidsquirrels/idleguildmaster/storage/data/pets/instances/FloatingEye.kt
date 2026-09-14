package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Esoteric

class FloatingEye : Esoteric() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_floating_eye
        idName = R.string.pet_floating_eye_name
        idDescription = R.string.pet_floating_eye_description
        abilityNumber = 2
    }
}
