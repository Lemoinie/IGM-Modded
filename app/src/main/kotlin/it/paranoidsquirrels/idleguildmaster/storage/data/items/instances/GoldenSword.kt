package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class GoldenSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_golden_sword_name
        idDescription = R.string.weapon_sword_golden_sword_description
        idImage = R.drawable.golden_sword
        price = 483L
        constitution = 12
        dexterity = 4
    }
}
