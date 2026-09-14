package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SkinBlender : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_skin_blender_name
        idDescription = R.string.accessory_skin_blender_description
        idEffect = R.string.accessory_skin_blender_effect
        idImage = R.drawable.skin_blender
        price = 987L
        criticalChance = 0.15
        criticalDamage = 0.15
        constitution = 24
        dexterity = 20
    }
}
