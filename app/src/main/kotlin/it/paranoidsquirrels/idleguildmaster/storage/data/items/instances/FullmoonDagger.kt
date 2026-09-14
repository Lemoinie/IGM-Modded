package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class FullmoonDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_fullmoon_dagger_name
        idDescription = R.string.weapon_dagger_fullmoon_dagger_description
        idEffect = R.string.weapon_dagger_fullmoon_dagger_effect
        idImage = R.drawable.fullmoon_dagger
        price = 45L
        constitution = 5
        dexterity = 5
        lifesteal = 15
    }
}
