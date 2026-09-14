package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SlimeKingsCrown : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_slime_kings_crown_name
        idDescription = R.string.accessory_slime_kings_crown_description
        idEffect = R.string.accessory_slime_kings_crown_effect
        idImage = R.drawable.slime_kings_crown
        source.add(R.string.raid_name_the_slime_pond)
        price = 5000L
        bonusExperience = 35
    }
}
