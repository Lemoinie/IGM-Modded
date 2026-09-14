package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class TrainingBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_training_bow_name
        idDescription = R.string.weapon_bow_training_bow_description
        idImage = R.drawable.training_bow
        price = 0L
        dexterity = 1
    }
}
