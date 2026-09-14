package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class Leather : Item() {
    override fun configureProperties() {
        idName = R.string.item_leather_name
        idDescription = R.string.item_leather_description
        idImage = R.drawable.leather
        price = 3L
    }

    override fun getSecondsToCraft(): Long {
        if (MainActivity.data.tutorialStep == 3) {
            return 10L
        }
        return super.getSecondsToCraft()
    }
}
