package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class CorruptedDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_corrupted_dagger_name
        idDescription = R.string.weapon_dagger_corrupted_dagger_description
        idImage = R.drawable.corrupted_dagger
        source.add(R.string.dungeon_name_the_golden_city)
        price = 1L
        dexterity = 1
    }
}
