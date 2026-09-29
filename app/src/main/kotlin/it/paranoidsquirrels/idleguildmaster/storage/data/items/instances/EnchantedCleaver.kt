package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class EnchantedCleaver : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_enchanted_cleaver_name
        idDescription = R.string.weapon_axe_enchanted_cleaver_description
        idEffect = R.string.weapon_axe_enchanted_cleaver_effect
        idImage = R.drawable.enchanted_cleaver
        price = 1800L
        constitution = 25
        intelligence = 25
    }

    override fun damageDelta(): Double = 0.30
}