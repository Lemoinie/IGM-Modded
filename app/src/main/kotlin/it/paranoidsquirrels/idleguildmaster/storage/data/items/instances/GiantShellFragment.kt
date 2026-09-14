package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class GiantShellFragment : Item() {
    override fun configureProperties() {
        idName = R.string.item_giant_shell_fragment_name
        idDescription = R.string.item_giant_shell_fragment_description
        idImage = R.drawable.giant_shell_fragment
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 2L
    }
}
