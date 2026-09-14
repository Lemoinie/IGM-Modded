package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class PirateKingTricorn : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_pirate_king_tricorn_name
        idDescription = R.string.accessory_pirate_king_tricorn_description
        idEffect = R.string.accessory_pirate_king_tricorn_effect
        idImage = R.drawable.pirate_king_tricorn
        price = 14600L
        maxHp = 100
        dexterity = 15
        intelligence = 10
        criticalDamage = 0.5
    }
}
