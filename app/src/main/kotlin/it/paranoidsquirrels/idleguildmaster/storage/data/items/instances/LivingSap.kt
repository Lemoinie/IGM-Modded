package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class LivingSap : Item() {
    override fun configureProperties() {
        idName = R.string.item_living_sap_name
        idDescription = R.string.item_living_sap_description
        idImage = R.drawable.living_sap
        source.add(R.string.dungeon_name_enchanted_forest)
        price = 10L
    }
}
