package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class PrimevalHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_primeval_helm_name
        idDescription = R.string.accessory_primeval_helm_description
        idImage = R.drawable.primeval_helm
        price = 1020L
        maxHp = 180
        defense = 12
    }
}
