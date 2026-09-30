package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class RatClaws : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_rat_claws_name
        idDescription = R.string.weapon_rat_claws_description
        idImage = R.drawable.rat_claws
        price = 0L
        constitution = 1
        dexterity = 1
        criticalChance = 0.05
    }
}
