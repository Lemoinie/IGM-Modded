package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class CopperSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_copper_sword_name
        idDescription = R.string.weapon_sword_copper_sword_description
        idImage = R.drawable.copper_sword
        price = 20L
        constitution = 3
        dexterity = 1
    }
}
