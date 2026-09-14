package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ElongatedBone : Item() {
    override fun configureProperties() {
        idName = R.string.item_elongated_bone_name
        idDescription = R.string.item_elongated_bone_description
        idImage = R.drawable.elongated_bone
        source.add(R.string.dungeon_name_eternal_battlefield)
        source.add(R.string.raid_name_ancient_grave_digging)
        price = 6L
    }
}
