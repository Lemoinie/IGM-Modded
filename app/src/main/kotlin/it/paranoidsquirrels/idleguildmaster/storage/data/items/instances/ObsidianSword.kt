package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class ObsidianSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_obsidian_sword_name
        idDescription = R.string.weapon_sword_obsidian_sword_description
        idImage = R.drawable.obsidian_sword
        price = 324L
        constitution = 21
        dexterity = 7
    }
}
