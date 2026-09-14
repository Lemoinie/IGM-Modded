package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class LivingScimitar : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_living_scimitar_name
        idDescription = R.string.weapon_sword_living_scimitar_description
        idEffect = R.string.weapon_sword_living_scimitar_effect
        idImage = R.drawable.living_scimitar
        price = 227L
        constitution = 10
        magicDefense = 5
        counterattack = 0.1
    }
}
