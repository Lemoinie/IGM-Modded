package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Reptile

class TreeFrog : Reptile() {
    override fun configureStatistics() {
        idImage = R.drawable.pet_tree_frog
        idName = R.string.pet_tree_frog_name
        idDescription = R.string.pet_tree_frog_description
        abilityNumber = 3
    }
}
