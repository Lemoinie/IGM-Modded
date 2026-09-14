package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class AnimatedStaff : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_animated_staff_name
        idDescription = R.string.weapon_staff_animated_staff_description
        idImage = R.drawable.animated_staff
        price = 635L
        intelligence = 40
    }
}
