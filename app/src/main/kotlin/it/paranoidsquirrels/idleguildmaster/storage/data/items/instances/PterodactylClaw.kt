package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class PterodactylClaw : Item() {
    override fun configureProperties() {
        idName = R.string.item_pterodactyl_claw_name
        idDescription = R.string.item_pterodactyl_claw_description
        idImage = R.drawable.pterodactyl_claw
        source.add(R.string.dungeon_name_lost_lands)
        price = 42L
    }
}
