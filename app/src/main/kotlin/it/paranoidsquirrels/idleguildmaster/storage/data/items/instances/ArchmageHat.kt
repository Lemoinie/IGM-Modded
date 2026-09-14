package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ArchmageHat : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_archmage_hat_name
        idDescription = R.string.accessory_archmage_hat_description
        idEffect = R.string.accessory_archmage_hat_effect
        idImage = R.drawable.archmage_hat
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 3200L
        intelligence = 35
        criticalDamage = 0.2
    }
}
