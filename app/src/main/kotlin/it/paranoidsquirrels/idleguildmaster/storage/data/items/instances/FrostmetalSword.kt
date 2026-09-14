package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class FrostmetalSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_frostmetal_sword_name
        idDescription = R.string.weapon_sword_frostmetal_sword_description
        idImage = R.drawable.frostmetal_sword
        price = 513L
        constitution = 18
        dexterity = 6
    }
}
