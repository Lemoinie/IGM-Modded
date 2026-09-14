package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class UnholySword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_unholy_sword_name
        idDescription = R.string.weapon_sword_unholy_sword_description
        idEffect = R.string.weapon_sword_unholy_sword_effect
        idImage = R.drawable.unholy_sword
        price = 1485L
        constitution = 27
        dexterity = 5
        retaliationMagicalDamage = 15
    }
}
