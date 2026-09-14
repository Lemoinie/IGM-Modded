package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class DivineEmbryo : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_divine_embryo_name
        idDescription = R.string.accessory_divine_embryo_description
        idEffect = R.string.accessory_divine_embryo_effect
        idImage = R.drawable.divine_embryo
        price = 17400L
        uniqueOrigin = "DivineZygote"
        notSellable = true
        constitution = 20
        dexterity = 20
        intelligence = 20
        immunityToStatus = 1.0
    }
}
