package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class TacticalHelmet : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_tactical_helmet_name
        idDescription = R.string.accessory_tactical_helmet_description
        idEffect = R.string.accessory_tactical_helmet_effect
        idImage = R.drawable.tactical_helmet
        price = 1152L
        darknessDamageAmplification = 0.005
        maxHp = 120
        dexterity = 12
    }
}
