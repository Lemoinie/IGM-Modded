package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class FrostmetalDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_frostmetal_dagger_name
        idDescription = R.string.weapon_dagger_frostmetal_dagger_description
        idImage = R.drawable.frostmetal_dagger
        price = 450L
        dexterity = 17
        constitution = 17
    }
}
