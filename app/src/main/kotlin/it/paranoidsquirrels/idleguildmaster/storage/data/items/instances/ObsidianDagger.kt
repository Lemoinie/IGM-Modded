package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class ObsidianDagger : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_obsidian_dagger_name
        idDescription = R.string.weapon_dagger_obsidian_dagger_description
        idImage = R.drawable.obsidian_dagger
        price = 306L
        dexterity = 20
        constitution = 20
    }
}
