package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class SpikedSkeleton : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_spiked_skeleton_name
        idDescription = R.string.armor_heavy_spiked_skeleton_description
        idEffect = R.string.armor_heavy_spiked_skeleton_effect
        idImage = R.drawable.spiked_skeleton
        price = 0L
        retaliationPhysicalDamage = 50
        constitution = 8
    }
}
