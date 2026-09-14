package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class Flute : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_flute_name
        idDescription = R.string.accessory_flute_description
        idEffect = R.string.accessory_flute_effect
        idImage = R.drawable.flute
        source.add(R.string.dungeon_name_the_golden_city)
        price = 100L
        exaltInspireBonusTurns = 1
        constitution = 5
        dexterity = 5
        intelligence = 5
    }
}
