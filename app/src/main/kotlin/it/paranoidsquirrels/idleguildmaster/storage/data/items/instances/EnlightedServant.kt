package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class EnlightedServant : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_enlighted_servant_name
        idDescription = R.string.accessory_enlighted_servant_description
        idEffect = R.string.accessory_enlighted_servant_effect
        idImage = R.drawable.enlighted_servant
        price = 28425L
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK_200_MAGIC
        maxHp = 150
        constitution = 40
    }
}
