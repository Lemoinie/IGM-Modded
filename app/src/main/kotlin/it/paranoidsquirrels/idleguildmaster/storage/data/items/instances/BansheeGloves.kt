package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class BansheeGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_banshee_gloves_name
        idDescription = R.string.accessory_banshee_gloves_description
        idImage = R.drawable.banshee_gloves
        price = 468L
        constitution = 22
        dexterity = 18
    }
}
