package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ArchaicAmulet : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_archaic_amulet_name
        idDescription = R.string.accessory_archaic_amulet_description
        idEffect = R.string.accessory_archaic_amulet_effect
        idImage = R.drawable.archaic_amulet
        price = 806L
        livingCompanionBonusDamage = 40
        maxHp = 140
    }
}
