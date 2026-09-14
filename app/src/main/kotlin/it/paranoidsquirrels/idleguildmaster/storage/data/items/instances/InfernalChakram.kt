package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class InfernalChakram : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_infernal_chakram_name
        idDescription = R.string.weapon_dagger_infernal_chakram_description
        idEffect = R.string.weapon_dagger_infernal_chakram_effect
        idImage = R.drawable.infernal_chakram
        price = 2625L
        dexterity = 50
    }

    override fun isRanged(): Boolean = true
}
