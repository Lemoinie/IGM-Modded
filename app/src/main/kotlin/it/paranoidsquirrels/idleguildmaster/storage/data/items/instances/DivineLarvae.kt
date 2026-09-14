package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class DivineLarvae : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_divine_larvae_name
        idDescription = R.string.accessory_divine_larvae_description
        idEffect = R.string.accessory_divine_larvae_effect
        idImage = R.drawable.divine_larvae
        price = 26130L
        uniqueOrigin = "DivineEmbryo"
        notSellable = true
        constitution = 25
        dexterity = 25
        intelligence = 25
        immunityToStatus = 1.0
    }
}
