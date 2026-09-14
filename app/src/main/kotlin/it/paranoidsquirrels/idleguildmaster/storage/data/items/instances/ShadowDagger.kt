package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class ShadowDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_shadow_dagger_name
        idDescription = R.string.weapon_dagger_shadow_dagger_description
        idEffect = R.string.weapon_dagger_shadow_dagger_effect
        idImage = R.drawable.shadow_dagger
        price = 1346L
        dexterity = 20
        constitution = 20
        darknessDamageAmplification = 0.005
    }
}
