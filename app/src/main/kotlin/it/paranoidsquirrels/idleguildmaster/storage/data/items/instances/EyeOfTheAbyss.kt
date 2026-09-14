package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class EyeOfTheAbyss : Item() {
    override fun configureProperties() {
        idName = R.string.item_eye_of_the_abyss_name
        idDescription = R.string.item_eye_of_the_abyss_description
        idImage = R.drawable.eye_of_the_abyss
        source.add(R.string.dungeon_name_blackwater_port)
        price = 75L
    }
}
