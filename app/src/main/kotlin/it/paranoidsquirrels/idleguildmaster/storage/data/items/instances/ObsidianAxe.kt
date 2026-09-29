package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class ObsidianAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_obsidian_axe_name
        idDescription = R.string.weapon_axe_obsidian_axe_description
        idImage = R.drawable.obsidian_axe
        price = 360L
        constitution = 20
        intelligence = 10
    }
}