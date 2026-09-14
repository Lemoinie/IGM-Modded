package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class TortoiseThorn : Item() {
    override fun configureProperties() {
        idName = R.string.item_tortoise_thorn_name
        idDescription = R.string.item_tortoise_thorn_description
        idImage = R.drawable.tortoise_thorn
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 18L
    }
}
