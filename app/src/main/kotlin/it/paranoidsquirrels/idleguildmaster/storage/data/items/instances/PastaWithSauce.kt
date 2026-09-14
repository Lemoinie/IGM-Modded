package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food

class PastaWithSauce : Food() {
    override fun configureProperties() {
        idName = R.string.food_pasta_with_sauce_name
        idDescription = R.string.food_pasta_with_sauce_description
        idImage = R.drawable.pasta_with_sauce
        price = 66L
        feedPower = 173
    }
}
