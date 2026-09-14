package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class PrismaticPendant : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_prismatic_pendant_name
        idDescription = R.string.accessory_prismatic_pendant_description
        idEffect = R.string.accessory_prismatic_pendant_effect
        idImage = R.drawable.prismatic_pendant
        price = 19500L
        bonusExperience = 65
    }
}
