package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class PrimevalArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_primeval_armor_name
        idDescription = R.string.armor_heavy_primeval_armor_description
        idImage = R.drawable.primeval_armor
        price = 1296L
        maxHp = 270
        constitution = 9
        defense = 15
    }
}
