package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wooden

class HolyTree : Wooden() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_holy_tree
        idName = R.string.pet_holy_tree_name
        idDescription = R.string.pet_holy_tree_description
        abilityNumber = 4
    }
}
