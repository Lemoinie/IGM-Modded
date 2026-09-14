package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class CopperArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_copper_armor_name
        idDescription = R.string.armor_heavy_copper_armor_description
        idImage = R.drawable.copper_armor
        price = 20L
        maxHp = 30
        constitution = 1
    }

    override fun getSecondsToCraft(): Long {
        if (MainActivity.data.tutorialStep == 4) {
            return 20L
        }
        return super.getSecondsToCraft()
    }
}
