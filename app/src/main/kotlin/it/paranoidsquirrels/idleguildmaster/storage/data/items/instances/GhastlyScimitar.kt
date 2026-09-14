package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class GhastlyScimitar : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_ghastly_scimitar_name
        idDescription = R.string.weapon_sword_ghastly_scimitar_description
        idEffect = R.string.weapon_sword_ghastly_scimitar_effect
        idImage = R.drawable.ghastly_scimitar
        price = 416L
        constitution = 16
        magicDefense = 10
        counterattack = 0.2
    }
}
