package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class CrystalDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_crystal_dagger_name
        idDescription = R.string.weapon_dagger_crystal_dagger_description
        idEffect = R.string.weapon_dagger_crystal_dagger_effect
        idImage = R.drawable.crystal_dagger
        price = 378L
        dexterity = 17
        constitution = 17
        criticalDamage = 0.3
    }
}
