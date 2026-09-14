package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class GhostwoodBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_ghostwood_bow_name
        idDescription = R.string.weapon_bow_ghostwood_bow_description
        idImage = R.drawable.ghostwood_bow
        price = 248L
        intelligence = 4
        dexterity = 16
    }
}
