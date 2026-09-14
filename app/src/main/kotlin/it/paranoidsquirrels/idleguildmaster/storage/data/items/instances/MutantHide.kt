package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class MutantHide : Item() {
    override fun configureProperties() {
        idName = R.string.item_mutant_hide_name
        idDescription = R.string.item_mutant_hide_description
        idImage = R.drawable.mutant_hide
        source.add(R.string.raid_name_kaunis)
        price = 55L
    }
}
