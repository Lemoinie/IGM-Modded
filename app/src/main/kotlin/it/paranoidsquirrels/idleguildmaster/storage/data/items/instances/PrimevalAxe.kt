package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Axe

class PrimevalAxe : Axe() {
    override fun configureProperties() {
        idName = R.string.weapon_axe_primeval_axe_name
        idDescription = R.string.weapon_axe_primeval_axe_description
        idEffect = R.string.weapon_axe_primeval_axe_effect
        idImage = R.drawable.primeval_axe
        price = 2200L
        constitution = 35
        defense = 15
        magicDefense = 10
        retaliationPhysicalDamage = 15
    }
}