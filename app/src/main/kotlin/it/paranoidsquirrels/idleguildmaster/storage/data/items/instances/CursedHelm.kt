package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class CursedHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_cursed_helm_name
        idDescription = R.string.accessory_cursed_helm_description
        idEffect = R.string.accessory_cursed_helm_effect
        idImage = R.drawable.cursed_helm
        price = 2880L
        maxHp = 105
        retaliationPhysicalDamage = 15
    }
}
