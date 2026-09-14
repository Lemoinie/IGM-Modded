package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class UndeadGreaves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_undead_greaves_name
        idDescription = R.string.accessory_undead_greaves_description
        idImage = R.drawable.undead_greaves
        price = 75L
        dexterity = 9
    }
}
