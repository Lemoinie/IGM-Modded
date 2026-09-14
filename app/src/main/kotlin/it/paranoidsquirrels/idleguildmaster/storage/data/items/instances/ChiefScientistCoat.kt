package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class ChiefScientistCoat : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_chief_scientist_coat_name
        idDescription = R.string.armor_light_chief_scientist_coat_description
        idEffect = R.string.armor_light_chief_scientist_coat_effect
        idImage = R.drawable.chief_scientist_coat
        source.add(R.string.raid_name_kaunis)
        price = 17500L
        healingModifier = 0.25
        intelligence = 72
    }
}
