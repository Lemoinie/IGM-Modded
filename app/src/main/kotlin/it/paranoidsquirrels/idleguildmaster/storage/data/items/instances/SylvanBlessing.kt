package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class SylvanBlessing : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_sylvan_blessing_name
        idDescription = R.string.weapon_staff_sylvan_blessing_description
        idEffect = R.string.weapon_staff_sylvan_blessing_effect
        idImage = R.drawable.sylvan_blessing
        price = 19853L
        healingModifier = 0.4
        intelligence = 45
    }
}
