package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class AbyssalScarletMantle : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_abyssal_scarlet_mantle_name
        idDescription = R.string.accessory_abyssal_scarlet_mantle_description
        idEffect = R.string.accessory_abyssal_scarlet_mantle_effect
        idImage = R.drawable.abyssal_scarlet_mantle
        price = 214465L
        constitution = 50
        dexterity = 50
        intelligence = 50
        criticalChance = 0.35
        criticalDamage = 0.40
    }
}