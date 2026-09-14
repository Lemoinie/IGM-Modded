package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class DivineZygote : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_divine_zygote_name
        idDescription = R.string.accessory_divine_zygote_description
        idEffect = R.string.accessory_divine_zygote_effect
        idImage = R.drawable.divine_zygote
        source.add(R.string.raid_name_divine_archeology)
        price = 10000L
        uniqueOrigin = getTrueClass()
        notSellable = true
        constitution = 7
        dexterity = 7
        intelligence = 7
        immunityToStatus = 1.0
    }
}
