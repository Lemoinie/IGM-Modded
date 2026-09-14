package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class InfectedBlood : Item() {
    override fun configureProperties() {
        idName = R.string.item_infected_blood_name
        idDescription = R.string.item_infected_blood_description
        idImage = R.drawable.infected_blood
        source.add(R.string.dungeon_name_eternal_battlefield)
        price = 13L
    }
}
