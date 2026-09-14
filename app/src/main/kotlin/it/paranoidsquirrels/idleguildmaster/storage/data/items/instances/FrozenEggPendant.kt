package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class FrozenEggPendant : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_frozen_egg_pendant_name
        idDescription = R.string.accessory_frozen_egg_pendant_description
        idEffect = R.string.accessory_frozen_egg_pendant_effect
        idImage = R.drawable.frozen_egg_pendant
        price = 341L
        freezeBonusDamage = 40
        maxHp = 90
        defense = 7
    }
}
