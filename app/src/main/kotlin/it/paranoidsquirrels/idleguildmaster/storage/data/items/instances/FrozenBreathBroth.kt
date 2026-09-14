package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class FrozenBreathBroth : Food() {
    override fun configureProperties() {
        idName = R.string.food_frozen_breath_broth_name
        idDescription = R.string.food_frozen_breath_broth_description
        idImage = R.drawable.frozen_breath_broth
        price = 41L
        feedPower = 219
    }
}
