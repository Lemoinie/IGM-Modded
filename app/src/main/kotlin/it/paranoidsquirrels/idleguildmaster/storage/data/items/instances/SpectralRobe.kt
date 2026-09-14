package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor

class SpectralRobe : LightArmor() {
    override fun configureProperties() {
        idName = R.string.armor_light_spectral_robe_name
        idDescription = R.string.armor_light_spectral_robe_description
        idImage = R.drawable.spectral_robe
        price = 135L
        maxHp = 30
        intelligence = 9
    }
}
