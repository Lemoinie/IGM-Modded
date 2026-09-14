package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Kindlequartz : Item() {
    override fun configureProperties() {
        idName = R.string.item_kindlequartz_name
        idDescription = R.string.item_kindlequartz_description
        idImage = R.drawable.kindlequartz
        source.add(R.string.dungeon_name_lost_lands)
        price = 220L
    }
}
