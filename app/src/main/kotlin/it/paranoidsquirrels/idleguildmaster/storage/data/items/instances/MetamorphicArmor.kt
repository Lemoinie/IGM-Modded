package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class MetamorphicArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_metamorphic_armor_name
        idDescription = R.string.armor_heavy_metamorphic_armor_description
        idEffect = R.string.armor_heavy_metamorphic_armor_effect
        idImage = R.drawable.metamorphic_armor
        price = 1188L
        maxHp = 140
        constitution = 5
        retaliationPhysicalDamage = 10
    }
}
