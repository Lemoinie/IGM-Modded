package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class WoodenBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_wooden_bow_name
        idDescription = R.string.weapon_bow_wooden_bow_description
        idImage = R.drawable.wooden_bow
        price = 11L
        constitution = 1
        dexterity = 3
    }
}
