package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class VampireBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_vampire_bow_name
        idDescription = R.string.weapon_bow_vampire_bow_description
        idEffect = R.string.weapon_bow_vampire_bow_effect
        idImage = R.drawable.vampire_bow
        price = 1040L
        intelligence = 6
        dexterity = 22
        lifesteal = 20
    }
}
