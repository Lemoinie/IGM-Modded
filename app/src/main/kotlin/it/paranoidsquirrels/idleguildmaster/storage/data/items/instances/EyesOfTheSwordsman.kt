package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class EyesOfTheSwordsman : Item() {
    override fun configureProperties() {
        idName = R.string.item_eyes_of_the_swordsman_name
        idDescription = R.string.item_eyes_of_the_swordsman_description
        idImage = R.drawable.eyes_of_the_swordsman
        source.add(R.string.raid_name_divine_archeology)
        uniqueOrigin = getTrueClass()
        notSellable = true
        price = 5000L
    }
}
