package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SoulShard : Item() {
    override fun configureProperties() {
        idName = R.string.item_soul_shard_name
        idDescription = R.string.item_soul_shard_description
        idImage = R.drawable.soul_shard
        source.add(R.string.dungeon_name_eternal_battlefield)
        source.add(R.string.raid_name_ancient_grave_digging)
        price = 100L
    }
}
