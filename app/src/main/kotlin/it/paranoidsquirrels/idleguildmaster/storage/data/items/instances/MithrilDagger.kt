package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class MithrilDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_mithril_dagger_name
        idDescription = R.string.weapon_dagger_mithril_dagger_description
        idImage = R.drawable.mithril_dagger
        price = 996L
        constitution = 33
        dexterity = 33
    }
}
