package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class VampireSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_vampire_sword_name
        idDescription = R.string.weapon_sword_vampire_sword_description
        idEffect = R.string.weapon_sword_vampire_sword_effect
        idImage = R.drawable.vampire_sword
        price = 1026L
        constitution = 21
        dexterity = 7
        lifesteal = 20
    }
}
