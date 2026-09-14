package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class BansheeBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_banshee_bow_name
        idDescription = R.string.weapon_bow_banshee_bow_description
        idImage = R.drawable.banshee_bow
        price = 1967L
        dexterity = 28
        intelligence = 8
    }
}
