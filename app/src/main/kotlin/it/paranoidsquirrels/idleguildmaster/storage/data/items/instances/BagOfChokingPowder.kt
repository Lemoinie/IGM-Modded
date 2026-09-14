package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BagOfChokingPowder : Item() {
    override fun configureProperties() {
        idName = R.string.item_bag_of_choking_powder_name
        idDescription = R.string.item_bag_of_choking_powder_description
        idImage = R.drawable.bag_of_choking_powder
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 38L
    }
}
