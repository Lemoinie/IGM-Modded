package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class WickedCleaver : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_wicked_cleaver_name
        idDescription = R.string.weapon_axe_wicked_cleaver_description
        idEffect = R.string.weapon_axe_wicked_cleaver_effect
        idImage = R.drawable.wicked_cleaver
        price = 3850L
        constitution = 25
        intelligence = 25
        flatDodgeChance = 0.1
    }

    override fun damageDelta(): Double = 0.50
}