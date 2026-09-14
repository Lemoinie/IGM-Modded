package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger

class GlassKnife : Dagger() {
    override fun configureProperties() {
        idName = R.string.weapon_dagger_glass_knife_name
        idDescription = R.string.weapon_dagger_glass_knife_description
        idImage = R.drawable.glass_knife
        price = 56L
        constitution = 5
        dexterity = 5
    }
}
