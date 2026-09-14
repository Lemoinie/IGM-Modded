package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class UndeadSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_undead_sword_name
        idDescription = R.string.weapon_sword_undead_sword_description
        idImage = R.drawable.undead_sword
        price = 54L
        constitution = 9
        dexterity = 3
    }
}
