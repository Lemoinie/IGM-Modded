package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ShortCircuit : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_short_circuit_name
        idDescription = R.string.accessory_short_circuit_description
        idEffect = R.string.accessory_short_circuit_effect
        idImage = R.drawable.short_circuit
        price = 705L
        endOfTurnAction = EndOfTurnAction.STUN_FLAT
        dexterity = 25
    }
}
