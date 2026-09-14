package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class UndeadCuirass : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_undead_cuirass_name
        idDescription = R.string.armor_heavy_undead_cuirass_description
        idImage = R.drawable.undead_cuirass
        price = 72L
        maxHp = 90
        constitution = 3
    }
}
