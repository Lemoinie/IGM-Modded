package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ShieldingHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_shielding_helm_name
        idDescription = R.string.accessory_shielding_helm_description
        idEffect = R.string.accessory_shielding_helm_effect
        idImage = R.drawable.shielding_helm
        price = 797L
        immunityToStatus = 0.25
        maxHp = 200
        constitution = 3
    }
}
