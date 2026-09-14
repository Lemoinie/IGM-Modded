package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class Mottiphobia : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_mottiphobia_name
        idDescription = R.string.weapon_dagger_mottiphobia_description
        idEffect = R.string.weapon_dagger_mottiphobia_effect
        idImage = R.drawable.mottiphobia
        price = 3758L
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK_HP_TO_DAMAGE
        maxHp = 25
        dexterity = 10
    }
}
