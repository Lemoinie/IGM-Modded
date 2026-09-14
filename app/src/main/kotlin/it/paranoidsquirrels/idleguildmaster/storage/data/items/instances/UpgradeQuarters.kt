package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade

class UpgradeQuarters : Upgrade() {
    override fun configureProperties() {
        idName = R.string.upgrade_quarters_name
        idDescription = R.string.upgrade_quarters_description
        idImage = R.drawable.upgrade_quarters
        notSellable = true
        price = 1L
        gemPrice = 500
    }

    override fun use() {
        MainActivity.data.upgradeQuarters++
    }
}
