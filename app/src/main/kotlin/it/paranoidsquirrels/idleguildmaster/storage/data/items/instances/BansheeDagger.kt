package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class BansheeDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_banshee_dagger_name
        idDescription = R.string.weapon_dagger_banshee_dagger_description
        idImage = R.drawable.banshee_dagger
        price = 552L
        constitution = 28
        dexterity = 28
    }
}
