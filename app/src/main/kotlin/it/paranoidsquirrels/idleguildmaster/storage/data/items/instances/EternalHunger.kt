package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class EternalHunger : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_eternal_hunger_name
        idDescription = R.string.accessory_eternal_hunger_description
        idEffect = R.string.accessory_eternal_hunger_effect
        idImage = R.drawable.eternal_hunger
        source.add(R.string.raid_name_the_cultist_rebels)
        price = 15000L
        intelligence = 5
        lifesteal = 50
    }
}
