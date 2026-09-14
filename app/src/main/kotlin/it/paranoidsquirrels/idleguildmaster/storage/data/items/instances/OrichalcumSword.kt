package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class OrichalcumSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_orichalcum_sword_name
        idDescription = R.string.weapon_sword_orichalcum_sword_description
        idImage = R.drawable.orichalcum_sword
        price = 1440L
        constitution = 39
        dexterity = 13
    }
}
