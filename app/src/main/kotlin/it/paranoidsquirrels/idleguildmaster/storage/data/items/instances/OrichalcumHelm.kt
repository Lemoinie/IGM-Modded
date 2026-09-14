package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class OrichalcumHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_orichalcum_helm_name
        idDescription = R.string.accessory_orichalcum_helm_description
        idImage = R.drawable.orichalcum_helm
        price = 1755L
        maxHp = 280
    }
}
