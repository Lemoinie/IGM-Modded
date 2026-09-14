package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ShadowRing : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_shadow_ring_name
        idDescription = R.string.accessory_shadow_ring_description
        idEffect = R.string.accessory_shadow_ring_effect
        idImage = R.drawable.shadow_ring
        price = 93L
        dexterity = 24
        initiative = true
        criticalChance = 0.12
    }
}
