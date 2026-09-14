package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class BleakBoots : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_bleak_boots_name
        idDescription = R.string.accessory_bleak_boots_description
        idEffect = R.string.accessory_bleak_boots_effect
        idImage = R.drawable.bleak_boots
        price = 2016L
        flatDodgeChance = 0.2
        dexterity = 34
    }
}
