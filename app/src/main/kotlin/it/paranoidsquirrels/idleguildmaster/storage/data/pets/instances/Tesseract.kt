package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Construct

class Tesseract : Construct() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_tesseract
        idName = R.string.pet_tesseract_name
        idDescription = R.string.pet_tesseract_description
        abilityNumber = 4
    }
}
