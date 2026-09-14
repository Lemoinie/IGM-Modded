package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class Sickle : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_sickle_name
        idDescription = R.string.weapon_dagger_sickle_description
        idImage = R.drawable.sickle
        price = 0L
        dexterity = 1
        constitution = 1
    }
}
