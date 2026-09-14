package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class InfiniteDespair : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_infinite_despair_name
        idDescription = R.string.weapon_dagger_infinite_despair_description
        idEffect = R.string.weapon_dagger_infinite_despair_effect
        idImage = R.drawable.infinite_despair
        price = 21000L
        constitution = 60
        dexterity = 60
        decay = 60
        criticalDamage = 1.0
    }
}
