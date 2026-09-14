package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class ObsidianHelm : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_obsidian_helm_name
        idDescription = R.string.accessory_obsidian_helm_description
        idImage = R.drawable.obsidian_helm
        price = 270L
        maxHp = 140
    }
}
