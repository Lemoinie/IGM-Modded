package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class RitualBlade : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_ritual_blade_name
        idDescription = R.string.weapon_dagger_ritual_blade_description
        idEffect = R.string.weapon_dagger_ritual_blade_effect
        idImage = R.drawable.ritual_blade
        price = 15393L
        dexterity = 12
        intelligence = 16
        healingModifier = 0.6
    }

    override fun isRanged(): Boolean = true
}
