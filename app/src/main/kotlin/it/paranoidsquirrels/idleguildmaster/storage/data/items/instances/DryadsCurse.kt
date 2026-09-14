package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class DryadsCurse : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_dryads_curse_name
        idDescription = R.string.weapon_dagger_dryads_curse_description
        idEffect = R.string.weapon_dagger_dryads_curse_effect
        idImage = R.drawable.dryads_curse
        price = 504L
        intelligence = 30
        dexterity = 18
        constitution = 18
    }

    override fun isMagic(): Boolean = true
}
