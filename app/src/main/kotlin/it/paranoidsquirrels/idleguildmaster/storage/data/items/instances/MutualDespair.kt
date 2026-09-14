package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class MutualDespair : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_mutual_despair_name
        idDescription = R.string.weapon_dagger_mutual_despair_description
        idEffect = R.string.weapon_dagger_mutual_despair_effect
        idImage = R.drawable.mutual_despair
        price = 10500L
        constitution = 30
        dexterity = 30
        decay = 20
        criticalDamage = 0.65
    }
}
