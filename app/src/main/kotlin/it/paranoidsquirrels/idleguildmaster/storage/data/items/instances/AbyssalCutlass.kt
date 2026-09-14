package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class AbyssalCutlass : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_abyssal_cutlass_name
        idDescription = R.string.weapon_sword_abyssal_cutlass_description
        idImage = R.drawable.abyssal_cutlass
        price = 5501L
        constitution = 24
    }
}
