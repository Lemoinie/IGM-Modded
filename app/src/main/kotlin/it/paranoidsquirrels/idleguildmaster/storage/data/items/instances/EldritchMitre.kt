package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class EldritchMitre : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_eldritch_mitre_name
        idDescription = R.string.accessory_eldritch_mitre_description
        idEffect = R.string.accessory_eldritch_mitre_effect
        idImage = R.drawable.eldritch_mitre
        price = 2255L
        maxHp = 50
        intelligence = 45
        healingModifier = -0.99
    }
}
