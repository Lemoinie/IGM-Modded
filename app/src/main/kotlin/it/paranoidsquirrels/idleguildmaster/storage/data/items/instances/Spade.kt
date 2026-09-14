package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class Spade : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_spade_name
        idDescription = R.string.weapon_sword_spade_description
        idImage = R.drawable.spade
        price = 0L
        constitution = 1
    }
}
