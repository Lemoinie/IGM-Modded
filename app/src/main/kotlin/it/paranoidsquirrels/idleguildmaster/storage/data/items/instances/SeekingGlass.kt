package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SeekingGlass : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_seeking_glass_name
        idDescription = R.string.accessory_seeking_glass_description
        idEffect = R.string.accessory_seeking_glass_effect
        idImage = R.drawable.seeking_glass
        source.add(R.string.raid_name_the_slime_pond)
        price = 10000L
        alwaysHits = true
        intelligence = 25
    }
}
