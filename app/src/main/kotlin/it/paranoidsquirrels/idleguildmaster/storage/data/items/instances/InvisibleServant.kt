package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class InvisibleServant : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_invisible_servant_name
        idDescription = R.string.accessory_invisible_servant_description
        idEffect = R.string.accessory_invisible_servant_effect
        idImage = R.drawable.invisible_servant
        price = 16200L
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK_140_MAGIC
        maxHp = 135
        constitution = 35
    }
}
