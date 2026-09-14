package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class RedwoodBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_redwood_bow_name
        idDescription = R.string.weapon_bow_redwood_bow_description
        idImage = R.drawable.redwood_bow
        price = 123L
        constitution = 4
        dexterity = 12
    }
}
