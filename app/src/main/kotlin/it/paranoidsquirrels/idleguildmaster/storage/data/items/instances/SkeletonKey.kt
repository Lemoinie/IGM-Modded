package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SkeletonKey : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_skeleton_key_name
        idDescription = R.string.accessory_skeleton_key_description
        idEffect = R.string.accessory_skeleton_key_effect
        idImage = R.drawable.skeleton_key
        source.add(R.string.raid_name_imperial_rescue)
        price = 35L
        uniqueOrigin = getTrueClass()
        notSellable = true
        intelligence = 36
    }
}
