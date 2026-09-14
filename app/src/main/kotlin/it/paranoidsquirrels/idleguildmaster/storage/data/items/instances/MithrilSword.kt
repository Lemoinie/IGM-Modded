package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class MithrilSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_mithril_sword_name
        idDescription = R.string.weapon_sword_mithril_sword_description
        idImage = R.drawable.mithril_sword
        price = 1020L
        constitution = 33
        dexterity = 11
    }
}
