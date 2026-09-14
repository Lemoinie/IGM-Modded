package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ShahuriBowFrame : Item() {
    override fun configureProperties() {
        idName = R.string.item_shahuri_bow_frame_name
        idDescription = R.string.item_shahuri_bow_frame_description
        idImage = R.drawable.shahuri_bow_frame
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.raid_name_divine_archeology)
        price = 55L
    }
}
