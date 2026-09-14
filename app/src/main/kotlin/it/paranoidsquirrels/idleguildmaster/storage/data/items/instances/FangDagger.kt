package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class FangDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_fang_dagger_name
        idDescription = R.string.weapon_dagger_fang_dagger_description
        idImage = R.drawable.fang_dagger
        price = 17L
        constitution = 2
        dexterity = 2
    }
}
