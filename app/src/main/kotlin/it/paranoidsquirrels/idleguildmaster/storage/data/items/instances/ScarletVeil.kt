package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class ScarletVeil : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_scarlet_veil_name
        idDescription = R.string.armor_medium_scarlet_veil_description
        idEffect = R.string.armor_medium_scarlet_veil_effect
        idImage = R.drawable.scarlet_veil
        price = 80000L
        maxHp = 270
        constitution = 30
        dexterity = 24
        criticalChance = 0.18
    }
}
