package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class UndeadKnife : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_undead_knife_name
        idDescription = R.string.weapon_dagger_undead_knife_description
        idEffect = R.string.weapon_dagger_undead_knife_effect
        idImage = R.drawable.undead_knife
        price = 54L
        constitution = 7
        dexterity = 7
        criticalChance = 0.06
    }
}
