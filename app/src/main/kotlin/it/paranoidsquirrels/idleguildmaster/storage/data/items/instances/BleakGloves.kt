package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class BleakGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_bleak_gloves_name
        idDescription = R.string.accessory_bleak_gloves_description
        idEffect = R.string.accessory_bleak_gloves_effect
        idImage = R.drawable.bleak_gloves
        price = 1584L
        flatDodgeChance = 0.2
        constitution = 18
        dexterity = 19
    }
}
