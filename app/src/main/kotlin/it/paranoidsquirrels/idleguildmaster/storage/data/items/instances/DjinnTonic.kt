package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class DjinnTonic : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_djinn_tonic_name
        idDescription = R.string.accessory_djinn_tonic_description
        idEffect = R.string.accessory_djinn_tonic_effect
        idImage = R.drawable.djinn_tonic
        price = 233L
        maxHp = 15
        constitution = 4
        intelligence = 4
        immunityToStatus = 0.2
    }
}
