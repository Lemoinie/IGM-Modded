package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ObsidianChunk : Item() {
    override fun configureProperties() {
        idName = R.string.item_obsidian_chunk_name
        idDescription = R.string.item_obsidian_chunk_description
        idImage = R.drawable.obsidian_chunk
        source.add(R.string.dungeon_name_obsidian_mines)
        source.add(R.string.raid_name_the_lost_expedition)
        price = 3L
    }
}
