package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ToxinPouch : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_toxin_pouch_name
        idDescription = R.string.accessory_toxin_pouch_description
        idEffect = R.string.accessory_toxin_pouch_effect
        idImage = R.drawable.toxin_pouch
        price = 654L
        poisonBonus = 4
        maxHp = 90
        intelligence = 15
    }
}
