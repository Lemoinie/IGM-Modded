package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SpiritTome : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_spirit_tome_name
        idDescription = R.string.accessory_spirit_tome_description
        idImage = R.drawable.spirit_tome
        source.add(R.string.dungeon_name_eternal_battlefield)
        price = 26L
        intelligence = 9
    }
}
