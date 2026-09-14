package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class IronChainmail : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_iron_chainmail_name
        idDescription = R.string.armor_heavy_iron_chainmail_description
        idImage = R.drawable.iron_chainmail
        price = 51L
        maxHp = 60
        constitution = 2
    }
}
