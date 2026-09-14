package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade

class UpgradeShelter : Upgrade() {
    override fun configureProperties() {
        idName = R.string.upgrade_shelter_name
        idDescription = R.string.upgrade_shelter_description
        idImage = R.drawable.upgrade_shelter
        notSellable = true
        price = 1L
        gemPrice = 500
    }

    override fun use() {
        MainActivity.data.upgradeShelter++
    }
}
