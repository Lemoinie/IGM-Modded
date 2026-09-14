package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class MetamorphicShield : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_metamorphic_shield_name
        idDescription = R.string.accessory_metamorphic_shield_description
        idEffect = R.string.accessory_metamorphic_shield_effect
        idImage = R.drawable.metamorphic_shield
        price = 143L
        constitution = 8
        retaliationPhysicalDamage = 6
    }
}
