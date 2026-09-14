package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class CeremonialDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_ceremonial_dagger_name
        idDescription = R.string.weapon_dagger_ceremonial_dagger_description
        idEffect = R.string.weapon_dagger_ceremonial_dagger_effect
        idImage = R.drawable.ceremonial_dagger
        price = 864L
        dexterity = 8
        intelligence = 8
        healingModifier = 0.4
    }

    override fun isRanged(): Boolean = true
}
