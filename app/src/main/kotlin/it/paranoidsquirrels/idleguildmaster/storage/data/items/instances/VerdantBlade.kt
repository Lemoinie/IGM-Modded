package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class VerdantBlade : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_verdant_blade_name
        idDescription = R.string.weapon_dagger_verdant_blade_description
        idImage = R.drawable.verdant_blade
        price = 246L
        dexterity = 23
        constitution = 23
    }
}
