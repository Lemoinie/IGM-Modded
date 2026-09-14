package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class GhastlyShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_ghastly_shield_name
        idDescription = R.string.accessory_ghastly_shield_description
        idEffect = R.string.accessory_ghastly_shield_effect
        idImage = R.drawable.ghastly_shield
        price = 155L
        maxHp = 25
        constitution = 9
        magicDefense = 8
        retaliationMagicalDamage = 10
    }
}
