package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AstralGoo : Item() {
    override fun configureProperties() {
        idName = R.string.item_astral_goo_name
        idDescription = R.string.item_astral_goo_description
        idImage = R.drawable.astral_goo
        source.add(R.string.raid_name_the_lost_expedition)
        price = 4L
    }
}
