package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class EmeraldRing : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_emerald_ring_name
        idDescription = R.string.accessory_emerald_ring_description
        idEffect = R.string.accessory_emerald_ring_effect
        idImage = R.drawable.emerald_ring
        price = 147L
        initiative = true
        magicDefense = 10
    }
}
