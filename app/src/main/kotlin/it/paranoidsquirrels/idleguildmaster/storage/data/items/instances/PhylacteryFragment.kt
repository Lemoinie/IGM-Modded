package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class PhylacteryFragment : Item() {
    override fun configureProperties() {
        idName = R.string.item_phylactery_fragment_name
        idDescription = R.string.item_phylactery_fragment_description
        idImage = R.drawable.phylactery_fragment
        source.add(R.string.raid_name_ancient_grave_digging)
        price = 450L
    }
}
