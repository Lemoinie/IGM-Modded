package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor

class ScarletShroud : MediumArmor() {
    override fun configureProperties() {
        idName = R.string.armor_medium_scarlet_shroud_name
        idDescription = R.string.armor_medium_scarlet_shroud_description
        idEffect = R.string.armor_medium_scarlet_shroud_effect
        idImage = R.drawable.scarlet_shroud
        price = 135000L
        maxHp = 300
        constitution = 50
        dexterity = 40
        criticalChance = 0.21
        criticalDamage = 0.21
    }
}
