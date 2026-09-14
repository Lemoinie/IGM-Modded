package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class RubyRing : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_ruby_ring_name
        idDescription = R.string.accessory_ruby_ring_description
        idEffect = R.string.accessory_ruby_ring_effect
        idImage = R.drawable.ruby_ring
        price = 147L
        initiative = true
        defense = 10
    }
}
