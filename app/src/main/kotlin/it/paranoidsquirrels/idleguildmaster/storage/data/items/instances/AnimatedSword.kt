package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class AnimatedSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_animated_sword_name
        idDescription = R.string.weapon_sword_animated_sword_description
        idImage = R.drawable.animated_sword
        price = 635L
        constitution = 30
        dexterity = 10
    }
}
