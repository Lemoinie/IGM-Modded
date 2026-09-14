package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class ObsidianBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_obsidian_bow_name
        idDescription = R.string.weapon_bow_obsidian_bow_description
        idImage = R.drawable.obsidian_bow
        price = 333L
        intelligence = 6
        dexterity = 22
    }
}
