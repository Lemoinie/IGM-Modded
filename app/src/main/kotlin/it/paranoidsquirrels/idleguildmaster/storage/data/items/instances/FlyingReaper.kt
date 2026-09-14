package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class FlyingReaper : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_flying_reaper_name
        idDescription = R.string.weapon_dagger_flying_reaper_description
        idEffect = R.string.weapon_dagger_flying_reaper_effect
        idImage = R.drawable.flying_reaper
        price = 2400L
        dexterity = 20
        constitution = 15
    }

    override fun isRanged(): Boolean = true
}
