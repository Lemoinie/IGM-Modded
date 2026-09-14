package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class VoltaicShock : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_voltaic_shock_name
        idDescription = R.string.accessory_voltaic_shock_description
        idEffect = R.string.accessory_voltaic_shock_effect
        idImage = R.drawable.voltaic_shock
        price = 4058L
        endOfTurnAction = EndOfTurnAction.STUN_FLAT_II
        dexterity = 30
        intelligence = 10
    }
}
