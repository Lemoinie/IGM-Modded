package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class MithrilBow : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_mithril_bow_name
        idDescription = R.string.weapon_bow_mithril_bow_description
        idImage = R.drawable.mithril_bow
        price = 1023L
        dexterity = 33
        intelligence = 11
    }
}
