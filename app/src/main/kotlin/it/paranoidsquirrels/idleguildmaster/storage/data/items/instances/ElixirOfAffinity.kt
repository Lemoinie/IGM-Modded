package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ElixirOfAffinity : Item() {
    override fun configureProperties() {
        idName = R.string.item_elixir_of_affinity_name
        idDescription = R.string.item_elixir_of_affinity_description
        idImage = R.drawable.elixir_of_affinity
        price = 1233L
    }
}
