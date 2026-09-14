package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class UndeadHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_undead_helm_name
        idDescription = R.string.accessory_undead_helm_description
        idImage = R.drawable.undead_helm
        price = 42L
        maxHp = 60
    }
}
