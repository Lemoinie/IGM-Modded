package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class DryadsBlessing : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_dryads_blessing_name
        idDescription = R.string.weapon_staff_dryads_blessing_description
        idEffect = R.string.weapon_staff_dryads_blessing_effect
        idImage = R.drawable.dryads_blessing
        price = 735L
        healingModifier = 0.23
        intelligence = 22
    }
}
