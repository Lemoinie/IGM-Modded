package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class KabelianClaws : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_kabelian_claws_name
        idDescription = R.string.accessory_kabelian_claws_description
        idEffect = R.string.accessory_kabelian_claws_effect
        idImage = R.drawable.kabelian_claws
        price = 6720L
        endOfTurnAction = EndOfTurnAction.BLEED_POKE_II
        dexterity = 16
        constitution = 15
    }
}
