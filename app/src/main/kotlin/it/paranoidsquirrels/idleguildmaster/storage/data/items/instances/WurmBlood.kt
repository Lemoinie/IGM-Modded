package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class WurmBlood : Item() {
    override fun configureProperties() {
        idName = R.string.item_wurm_blood_name
        idDescription = R.string.item_wurm_blood_description
        idImage = R.drawable.wurm_blood
        source.add(R.string.dungeon_name_the_desert)
        price = 2L
    }
}
