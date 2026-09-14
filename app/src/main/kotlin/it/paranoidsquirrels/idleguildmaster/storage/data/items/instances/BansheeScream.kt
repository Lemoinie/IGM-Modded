package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class BansheeScream : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_banshee_scream_name
        idDescription = R.string.weapon_bow_banshee_scream_description
        idEffect = R.string.weapon_bow_banshee_scream_effect
        idImage = R.drawable.banshee_scream
        price = 3152L
        criticalChance = 0.1
        dexterity = 38
        intelligence = 12
    }
}
