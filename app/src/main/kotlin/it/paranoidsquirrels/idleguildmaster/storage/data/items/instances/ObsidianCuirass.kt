package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class ObsidianCuirass : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_obsidian_cuirass_name
        idDescription = R.string.armor_heavy_obsidian_cuirass_description
        idImage = R.drawable.obsidian_cuirass
        price = 405L
        maxHp = 210
        constitution = 7
    }
}
