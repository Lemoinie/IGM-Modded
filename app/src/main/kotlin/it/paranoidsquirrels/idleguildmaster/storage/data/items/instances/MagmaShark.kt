package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class MagmaShark : Food() {
    override fun configureProperties() {
        idName = R.string.food_magma_shark_name
        idDescription = R.string.food_magma_shark_description
        idImage = R.drawable.magma_shark
        price = 300L
        feedPower = 150
    }
}