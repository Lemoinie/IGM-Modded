package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class OrichalcumDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_orichalcum_dagger_name
        idDescription = R.string.weapon_dagger_orichalcum_dagger_description
        idImage = R.drawable.orichalcum_dagger
        price = 1260L
        constitution = 39
        dexterity = 39
    }
}
