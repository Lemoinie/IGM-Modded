package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class SlimeArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_slime_armor_name
        idDescription = R.string.armor_heavy_slime_armor_description
        idImage = R.drawable.slime_armor
        price = 630L
        maxHp = 150
        defense = 5
    }
}
