package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class InfinityHat : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_infinity_hat_name
        idDescription = R.string.accessory_infinity_hat_description
        idEffect = R.string.accessory_infinity_hat_effect
        idImage = R.drawable.infinity_hat
        source.add(R.string.raid_name_sleeping_planet)
        price = 15000L
        maxHp = 60
        intelligence = 35
        criticalDamage = 0.25
    }
}
