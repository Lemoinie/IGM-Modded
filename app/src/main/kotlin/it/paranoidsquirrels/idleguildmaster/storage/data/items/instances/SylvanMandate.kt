package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class SylvanMandate : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_sylvan_mandate_name
        idDescription = R.string.weapon_dagger_sylvan_mandate_description
        idEffect = R.string.weapon_dagger_sylvan_mandate_effect
        idImage = R.drawable.sylvan_mandate
        price = 12006L
        intelligence = 50
        dexterity = 30
        constitution = 30
    }

    override fun isMagic(): Boolean = true
}
