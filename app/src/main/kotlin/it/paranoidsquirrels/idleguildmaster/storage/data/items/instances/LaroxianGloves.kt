package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class LaroxianGloves : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_laroxian_gloves_name
        idDescription = R.string.accessory_laroxian_gloves_description
        idImage = R.drawable.laroxian_gloves
        price = 393L
        constitution = 25
        dexterity = 20
    }
}
