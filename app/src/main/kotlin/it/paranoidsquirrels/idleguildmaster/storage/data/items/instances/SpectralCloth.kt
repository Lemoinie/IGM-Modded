package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class SpectralCloth : Item() {
    override fun configureProperties() {
        idName = R.string.item_spectral_cloth_name
        idDescription = R.string.item_spectral_cloth_description
        idImage = R.drawable.spectral_cloth
        source.add(R.string.dungeon_name_eternal_battlefield)
        price = 6L
    }
}
