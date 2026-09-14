package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class ShieldingJacket : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_shielding_jacket_name
        idDescription = R.string.armor_medium_shielding_jacket_description
        idEffect = R.string.armor_heavy_shielding_cuirass_effect
        idImage = R.drawable.shielding_jacket
        price = 1202L
        immunityToStatus = 0.3
        maxHp = 200
        constitution = 15
        dexterity = 10
    }
}
