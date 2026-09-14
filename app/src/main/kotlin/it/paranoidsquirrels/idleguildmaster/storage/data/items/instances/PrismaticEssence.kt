package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class PrismaticEssence : Item() {
    override fun configureProperties() {
        idName = R.string.item_prismatic_essence_name
        idDescription = R.string.item_prismatic_essence_description
        idImage = R.drawable.prismatic_essence
        price = 13000L
    }
}
