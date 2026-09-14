package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class CursedClaws : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_cursed_claws_name
        idDescription = R.string.accessory_cursed_claws_description
        idEffect = R.string.accessory_cursed_claws_effect
        idImage = R.drawable.cursed_claws
        price = 1920L
        endOfTurnAction = EndOfTurnAction.BLEED_POKE
        dexterity = 12
        constitution = 12
    }
}
