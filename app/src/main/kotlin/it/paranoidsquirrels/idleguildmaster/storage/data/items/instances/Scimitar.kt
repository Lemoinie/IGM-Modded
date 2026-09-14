package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class Scimitar : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_scimitar_name
        idDescription = R.string.weapon_sword_scimitar_description
        idImage = R.drawable.scimitar
        price = 41L
        constitution = 6
        dexterity = 2
    }
}
