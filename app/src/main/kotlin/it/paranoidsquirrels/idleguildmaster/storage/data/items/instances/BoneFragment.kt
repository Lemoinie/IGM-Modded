package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class BoneFragment : Item() {
    override fun configureProperties() {
        idName = R.string.item_bone_fragment_name
        idDescription = R.string.item_bone_fragment_description
        idImage = R.drawable.bone_fragment
        source.add(R.string.dungeon_name_eternal_battlefield)
        source.add(R.string.raid_name_ancient_grave_digging)
        price = 1L
    }
}
