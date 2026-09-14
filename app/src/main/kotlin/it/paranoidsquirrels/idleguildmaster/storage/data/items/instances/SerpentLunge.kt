package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class SerpentLunge : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_serpent_lunge_name
        idDescription = R.string.weapon_dagger_serpent_lunge_description
        idEffect = R.string.weapon_dagger_serpent_lunge_effect
        idImage = R.drawable.serpent_lunge
        price = 10000L
        source.add(R.string.raid_name_the_dire_descent)
        uniqueOrigin = getTrueClass()
        notSellable = true
        flatDodgeChance = 0.1
        dexterity = 25
        constitution = 25
    }
}
