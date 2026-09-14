package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class DreamwroughtBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_dreamwrought_bow_name
        idDescription = R.string.weapon_bow_dreamwrought_bow_description
        idImage = R.drawable.dreamwrought_bow
        price = 1055L
        dexterity = 39
        intelligence = 13
    }
}
