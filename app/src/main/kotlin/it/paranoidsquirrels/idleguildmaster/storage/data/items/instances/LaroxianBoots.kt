package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class LaroxianBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_laroxian_boots_name
        idDescription = R.string.accessory_laroxian_boots_description
        idImage = R.drawable.laroxian_boots
        price = 447L
        dexterity = 30
    }
}
