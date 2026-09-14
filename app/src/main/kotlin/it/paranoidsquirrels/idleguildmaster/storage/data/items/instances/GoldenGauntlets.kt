package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class GoldenGauntlets : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_golden_gauntlets_name
        idDescription = R.string.accessory_golden_gauntlets_description
        idImage = R.drawable.golden_gauntlets
        price = 228L
        constitution = 11
        dexterity = 9
    }
}
