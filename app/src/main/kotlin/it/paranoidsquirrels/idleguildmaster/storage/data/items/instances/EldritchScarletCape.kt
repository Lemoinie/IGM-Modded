package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class EldritchScarletCape : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_eldritch_scarlet_cape_name
        idDescription = R.string.accessory_eldritch_scarlet_cape_description
        idEffect = R.string.accessory_eldritch_scarlet_cape_effect
        idImage = R.drawable.eldritch_scarlet_cape
        price = 204465L
        constitution = 40
        dexterity = 40
        intelligence = 40
        criticalChance = 0.21
        criticalDamage = 0.21
    }
}