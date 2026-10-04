package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class BloodstoneClaws : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_bloodstone_claws_name
        idDescription = R.string.accessory_bloodstone_claws_description
        idEffect = R.string.accessory_bloodstone_claws_effect
        idImage = R.drawable.bloodstone_claws
        price = 17500L
        endOfTurnAction = EndOfTurnAction.BLEED_POKE_III
        constitution = 25
        dexterity = 26
        attackSpeed = 20
    }
}
