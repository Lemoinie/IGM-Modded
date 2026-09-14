package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class BlackIronCutlass : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_black_iron_cutlass_name
        idDescription = R.string.weapon_sword_black_iron_cutlass_description
        idImage = R.drawable.black_iron_cutlass
        price = 362L
        constitution = 15
        dexterity = 5
    }
}
