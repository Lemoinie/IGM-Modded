package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class VampireDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_vampire_dagger_name
        idDescription = R.string.weapon_dagger_vampire_dagger_description
        idEffect = R.string.weapon_dagger_vampire_dagger_effect
        idImage = R.drawable.vampire_dagger
        price = 999L
        dexterity = 20
        constitution = 20
        lifesteal = 20
    }
}
