package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ScarletCape : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_scarlet_cape_name
        idDescription = R.string.accessory_scarlet_cape_description
        idEffect = R.string.accessory_scarlet_cape_effect
        idImage = R.drawable.scarlet_cape
        price = 200000L
        constitution = 30
        dexterity = 30
        intelligence = 30
        criticalChance = 0.15
    }
}