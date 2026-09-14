package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class StarFragment : Item() {
    override fun configureProperties() {
        idName = R.string.item_star_fragment_name
        idDescription = R.string.item_star_fragment_description
        idImage = R.drawable.star_fragment
        source.add(R.string.raid_name_the_lost_expedition)
        price = 500L
    }
}
