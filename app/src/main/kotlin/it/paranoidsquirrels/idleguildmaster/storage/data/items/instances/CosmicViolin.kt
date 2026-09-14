package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class CosmicViolin : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_cosmic_violin_name
        idDescription = R.string.accessory_cosmic_violin_description
        idEffect = R.string.accessory_cosmic_violin_effect
        idImage = R.drawable.cosmic_violin
        source.add(R.string.raid_name_the_lost_expedition)
        price = 11111L
        exaltInspireBonusTurns = 3
        constitution = 25
        dexterity = 25
        intelligence = 25
    }
}
