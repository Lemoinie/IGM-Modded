package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ElixirOfLearning : Item() {
    override fun configureProperties() {
        idName = R.string.item_elixir_of_learning_name
        idDescription = R.string.item_elixir_of_learning_description
        idImage = R.drawable.elixir_of_learning
        source.add(R.string.raid_name_the_cultist_rebels)
        price = 65L
    }
}
