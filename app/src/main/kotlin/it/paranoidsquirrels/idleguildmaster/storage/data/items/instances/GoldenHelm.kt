package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class GoldenHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_golden_helm_name
        idDescription = R.string.accessory_golden_helm_description
        idImage = R.drawable.golden_helm
        price = 363L
        maxHp = 80
    }
}
