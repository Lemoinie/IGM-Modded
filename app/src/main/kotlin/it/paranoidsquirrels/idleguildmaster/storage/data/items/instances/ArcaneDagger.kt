package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class ArcaneDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_arcane_dagger_name
        idDescription = R.string.weapon_dagger_arcane_dagger_description
        idEffect = R.string.weapon_dagger_arcane_dagger_effect
        idImage = R.drawable.arcane_dagger
        price = 564L
        intelligence = 24
        dexterity = 12
        constitution = 12
    }

    override fun isMagic(): Boolean = true
}
