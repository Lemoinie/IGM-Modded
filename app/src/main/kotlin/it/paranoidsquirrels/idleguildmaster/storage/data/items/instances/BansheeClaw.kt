package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BansheeClaw : Item() {
    override fun configureProperties() {
        idName = R.string.item_banshee_claw_name
        idDescription = R.string.item_banshee_claw_description
        idImage = R.drawable.banshee_claw
        source.add(R.string.dungeon_name_barren_wastelands)
        price = 38L
    }
}
