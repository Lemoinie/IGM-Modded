package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade

class UpgradeStorage : Upgrade() {
    override fun configureProperties() {
        idName = R.string.upgrade_storage_name
        idDescription = R.string.upgrade_storage_description
        idImage = R.drawable.upgrade_storage
        notSellable = true
        price = 1L
        gemPrice = 80
    }

    override fun use() {
        MainActivity.data.upgradeStorage++
    }
}
