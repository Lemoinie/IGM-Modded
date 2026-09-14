package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class ShadowBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_shadow_bow_name
        idDescription = R.string.weapon_bow_shadow_bow_description
        idEffect = R.string.weapon_bow_shadow_bow_effect
        idImage = R.drawable.shadow_bow
        price = 1386L
        intelligence = 6
        dexterity = 22
        darknessDamageAmplification = 0.005
    }
}
