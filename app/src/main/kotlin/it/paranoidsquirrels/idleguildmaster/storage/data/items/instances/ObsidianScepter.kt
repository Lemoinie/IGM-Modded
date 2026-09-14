package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class ObsidianScepter : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_obsidian_scepter_name
        idDescription = R.string.weapon_staff_obsidian_scepter_description
        idImage = R.drawable.obsidian_scepter
        price = 324L
        intelligence = 28
    }
}
