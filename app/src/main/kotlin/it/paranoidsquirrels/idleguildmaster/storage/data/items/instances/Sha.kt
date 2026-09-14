package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class Sha : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_sha_name
        idDescription = R.string.accessory_sha_description
        idEffect = R.string.accessory_sha_effect
        idImage = R.drawable.sha
        price = 69150L
        uniqueOrigin = "DivineLarvae"
        notSellable = true
        constitution = 40
        dexterity = 40
        intelligence = 40
        immunityToStatus = 1.0
    }
}
