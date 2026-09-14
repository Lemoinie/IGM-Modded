package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class OrichalcumShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_orichalcum_shield_name
        idDescription = R.string.accessory_orichalcum_shield_description
        idImage = R.drawable.orichalcum_shield
        price = 1440L
        constitution = 42
    }
}
