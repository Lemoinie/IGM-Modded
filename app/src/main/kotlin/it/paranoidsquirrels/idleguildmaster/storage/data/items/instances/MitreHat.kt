package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class MitreHat : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_mitre_hat_name
        idDescription = R.string.accessory_mitre_hat_description
        idEffect = R.string.accessory_mitre_hat_effect
        idImage = R.drawable.mitre_hat
        source.add(R.string.dungeon_name_the_golden_city)
        price = 450L
        maxHp = 60
        intelligence = 9
        healingModifier = 0.2
    }
}
