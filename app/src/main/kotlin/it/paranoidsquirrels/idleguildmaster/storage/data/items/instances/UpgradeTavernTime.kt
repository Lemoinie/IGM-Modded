package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade

class UpgradeTavernTime : Upgrade() {
    override fun configureProperties() {
        idName = R.string.upgrade_tavern_time_name
        idDescription = R.string.upgrade_tavern_time_description
        idImage = R.drawable.upgrade_tavern_time
        notSellable = true
        price = 1L
        gemPrice = 300
    }

    override fun use() {
        MainActivity.data.upgradeTavernTime++
    }
}
