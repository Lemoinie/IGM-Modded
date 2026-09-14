package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class WinterwoodBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_winterwood_bow_name
        idDescription = R.string.weapon_bow_winterwood_bow_description
        idImage = R.drawable.winterwood_bow
        price = 275L
        intelligence = 5
        dexterity = 19
    }
}
