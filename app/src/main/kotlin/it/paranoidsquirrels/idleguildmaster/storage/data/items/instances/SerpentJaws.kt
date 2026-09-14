package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class SerpentJaws : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_serpent_jaws_name
        idDescription = R.string.weapon_sword_serpent_jaws_description
        idEffect = R.string.weapon_sword_serpent_jaws_effect
        idImage = R.drawable.serpent_jaws
        price = 0L
        counterattack = 0.35
        dexterity = 5
    }
}
