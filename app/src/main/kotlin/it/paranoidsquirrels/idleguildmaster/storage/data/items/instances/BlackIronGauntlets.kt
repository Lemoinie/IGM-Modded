package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class BlackIronGauntlets : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_black_iron_gauntlets_name
        idDescription = R.string.accessory_black_iron_gauntlets_description
        idImage = R.drawable.black_iron_gauntlets
        price = 278L
        constitution = 13
        dexterity = 11
    }
}
