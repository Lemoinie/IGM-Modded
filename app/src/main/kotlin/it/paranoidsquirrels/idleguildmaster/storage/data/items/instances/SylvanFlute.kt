package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SylvanFlute : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_sylvan_flute_name
        idDescription = R.string.accessory_sylvan_flute_description
        idEffect = R.string.accessory_sylvan_flute_effect
        idImage = R.drawable.sylvan_flute
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 540L
        exaltInspireBonusTurns = 2
        constitution = 10
        dexterity = 10
        intelligence = 10
    }
}
