package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Mythic

/** Kitsune (display name "Senko") — canonical Mythic pet with the Kitsune Spirit Blessing 5th trait.
 *  Replaces the legacy Senko class; saves referencing "Senko" or "Semi" resolve here. */
class Kitsune : Mythic() {
    init {
        trueClass = "Kitsune"
    }

    override fun configureStatistics() {
        idImage = R.drawable.pet_kitsune
        idName = R.string.pet_kitsune_name
        idDescription = R.string.pet_kitsune_description
        abilityNumber = 5
    }
}