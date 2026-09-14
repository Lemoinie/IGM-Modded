package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class BlackIronDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_black_iron_dagger_name
        idDescription = R.string.weapon_dagger_black_iron_dagger_description
        idImage = R.drawable.black_iron_dagger
        price = 342L
        dexterity = 14
        constitution = 14
    }
}
