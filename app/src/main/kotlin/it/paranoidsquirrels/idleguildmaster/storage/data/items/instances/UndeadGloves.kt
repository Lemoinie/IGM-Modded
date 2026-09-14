package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class UndeadGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_undead_gloves_name
        idDescription = R.string.accessory_undead_gloves_description
        idImage = R.drawable.undead_gloves
        price = 75L
        constitution = 7
        dexterity = 6
    }
}
