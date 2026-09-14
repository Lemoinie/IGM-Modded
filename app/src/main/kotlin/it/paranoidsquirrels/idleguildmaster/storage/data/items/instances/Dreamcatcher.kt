package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class Dreamcatcher : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_dreamcatcher_name
        idDescription = R.string.accessory_dreamcatcher_description
        idEffect = R.string.accessory_dreamcatcher_effect
        idImage = R.drawable.dreamcatcher
        price = 1L
        notSellable = true
        constitution = 3
        dexterity = 3
        intelligence = 3
        bonusExperience = 50
    }
}
